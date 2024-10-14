package com.do55anto5.moviestreaming.di

import com.do55anto5.moviestreaming.presenter.screens.authentication.login.viewmodel.LoginViewModel
import com.do55anto5.moviestreaming.presenter.screens.authentication.signup.viewmodel.SignupViewModel
import com.do55anto5.moviestreaming.presenter.screens.main.account.viewmodel.AccountViewModel
import com.do55anto5.moviestreaming.presenter.screens.main.download.viewmodel.DownloadViewModel
import com.do55anto5.moviestreaming.presenter.screens.main.favorite.viewmodel.FavoriteViewModel
import com.do55anto5.moviestreaming.presenter.screens.main.home.viewmodel.HomeViewModel
import com.do55anto5.moviestreaming.presenter.screens.main.search.viewmodel.SearchViewModel
import com.do55anto5.moviestreaming.presenter.screens.splash.viewmodel.SplashViewModel
import com.do55anto5.moviestreaming.presenter.screens.welcome.viewmodel.WelcomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {

    viewModel {
        SplashViewModel(
            appPreferences = get()
        )
    }

    viewModel {
        WelcomeViewModel(appPreferences = get())
    }

    viewModel {
        SignupViewModel(
            registerUseCase = get(),
            saveUserUseCase = get()
        )
    }

    viewModel {
        LoginViewModel(loginUseCase = get())
    }

    viewModel {
        HomeViewModel()
    }

    viewModel {
        SearchViewModel()
    }

    viewModel {
        FavoriteViewModel()
    }

    viewModel {
        DownloadViewModel()
    }

    viewModel {
        AccountViewModel()
    }

}