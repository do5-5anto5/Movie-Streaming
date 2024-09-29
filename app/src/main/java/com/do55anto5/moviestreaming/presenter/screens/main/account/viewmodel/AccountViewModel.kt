package com.do55anto5.moviestreaming.presenter.screens.main.account.viewmodel


import androidx.lifecycle.ViewModel
import com.do55anto5.moviestreaming.presenter.screens.main.account.action.AccountAction
import com.do55anto5.moviestreaming.presenter.screens.main.account.state.AccountState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AccountViewModel : ViewModel() {

    private val _state = MutableStateFlow(AccountState())
    val state = _state.asStateFlow()

    fun submitAction(action: AccountAction) {

    }

}