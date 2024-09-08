package com.do55anto5.moviestreaming.presenter.screens.authentication.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.do55anto5.moviestreaming.core.enums.InputType
import com.do55anto5.moviestreaming.core.functions.isValidEmail
import com.do55anto5.moviestreaming.core.helper.FirebaseHelper
import com.do55anto5.moviestreaming.domain.remote.usecase.authentication.RegisterUseCase
import com.do55anto5.moviestreaming.presenter.screens.authentication.signup.action.SignupAction
import com.do55anto5.moviestreaming.presenter.screens.authentication.signup.state.SignupState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignupViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SignupState())
    val state = _state.asStateFlow()

    fun submitAction(action: SignupAction) {
        when (action) {
            is SignupAction.OnValueChange -> {
                onValueChange(action.value, action.type)
            }

            is SignupAction.OnPasswordVisibilityChange -> {
                onPasswordVisibilityChange()
            }

            is SignupAction.OnSignup -> {
                onSignup()
            }
        }
    }

    private fun onSignup() {
        viewModelScope.launch {
            try {
                registerUseCase(
                    email = _state.value.email,
                    password = _state.value.password
                )
            } catch (exception: Exception) {
                exception.printStackTrace()

                _state.update { currentState ->
                    currentState.copy(
                        hasError = true,
                        errorMessage = FirebaseHelper.validateError(exception.message)
                    )
                }
            }
        }
    }

    private fun onValueChange(value: String, type: InputType) {
        when (type) {
            InputType.EMAIL -> {
                onEmailChange(value)
            }

            InputType.PASSWORD -> {
                onPasswordChange(value)
            }
        }

        enableSignupButton()
    }

    private fun onEmailChange(value: String) {
        _state.update { currentState ->
            currentState.copy(email = value)
        }
    }

    private fun onPasswordChange(value: String) {
        _state.update { currentState ->
            currentState.copy(password = value)
        }
    }

    private fun onPasswordVisibilityChange() {
        _state.update { currentState ->
            currentState.copy(passwordVisibility = !currentState.passwordVisibility)
        }
    }

    private fun enableSignupButton() {
        val emailValid = isValidEmail(_state.value.email)
        val passwordValid = _state.value.password.isNotBlank()

        _state.update { currentState ->
            currentState.copy(enableSignupButton = emailValid && passwordValid)
        }
    }

}