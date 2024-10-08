package com.do55anto5.moviestreaming.di

import com.do55anto5.moviestreaming.presenter.screens.authentication.login.viewmodel.LoginViewModel
import com.do55anto5.moviestreaming.presenter.screens.authentication.signup.viewmodel.SignupViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {

    viewModel {
        SignupViewModel(
            registerUseCase = get(),
            saveUserUseCase = get()
        )
    }

    viewModel {
        LoginViewModel(loginUseCase = get())
    }

}