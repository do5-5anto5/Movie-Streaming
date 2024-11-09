package com.do55anto5.moviestreaming.presenter.screens.main.account.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.do55anto5.moviestreaming.domain.remote.usecase.user.GetUserUseCase
import com.do55anto5.moviestreaming.presenter.screens.main.account.action.AccountAction
import com.do55anto5.moviestreaming.presenter.screens.main.account.state.AccountState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AccountViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(AccountState())
    val state = _state.asStateFlow()

    init {
        getUser()
    }

    fun submitAction(action: AccountAction) {

    }

    private fun getUser() {
        viewModelScope.launch {

            val user = getUserUseCase()

            _state.update { currentState -> currentState.copy(user = user) }
        }
    }

}