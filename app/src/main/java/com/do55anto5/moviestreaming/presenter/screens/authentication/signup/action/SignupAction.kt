package com.do55anto5.moviestreaming.presenter.screens.authentication.signup.action

import com.do55anto5.moviestreaming.core.enums.input.InputType

sealed class SignupAction {

    data class OnValueChange(
        val value: String,
        val type: InputType
    ) : SignupAction()

    data object OnPasswordVisibilityChange: SignupAction()

    data object OnSignup: SignupAction()
}