package com.do55anto5.moviestreaming.presenter.screens.splash.state


data class SplashState(
    val isAuthenticated: Boolean = false,
    val isWelcomeVisited: Boolean = false,
    val isLoading: Boolean = true
)