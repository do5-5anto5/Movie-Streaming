package com.do55anto5.moviestreaming.presenter.screens.welcome.viewmodel

import androidx.lifecycle.ViewModel
import com.do55anto5.moviestreaming.core.preferences.AppPreferences
import com.do55anto5.moviestreaming.presenter.screens.welcome.action.WelcomeAction
import com.do55anto5.moviestreaming.presenter.screens.welcome.state.WelcomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WelcomeViewModel(
    private val appPreferences: AppPreferences
) : ViewModel() {
    private val _state = MutableStateFlow(WelcomeState())
    val state = _state.asStateFlow()
    fun submitAction(action: WelcomeAction) {
        when (action) {
            is WelcomeAction.OnNextScreen -> {
                saveWelcomeVisited()
            }
        }
    }
    private fun saveWelcomeVisited() {
        appPreferences.saveWelcomeVisited(true)
        _state.update { currentState ->
            currentState.copy(nextScreen = true)
        }
    }
}