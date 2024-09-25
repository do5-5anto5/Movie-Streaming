package com.do55anto5.moviestreaming.core.navigation.hosts.authentication

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.do55anto5.moviestreaming.core.navigation.routes.authentication.AuthenticationRoutes
import com.do55anto5.moviestreaming.presenter.screens.authentication.home.screen.HomeAuthenticationScreen
import com.do55anto5.moviestreaming.presenter.screens.authentication.login.screen.LoginScreen
import com.do55anto5.moviestreaming.presenter.screens.authentication.signup.screen.SignupScreen


fun NavGraphBuilder.authenticationNavHost(navHostController: NavHostController) {
    navigation<AuthenticationRoutes.Graph>(
        startDestination = AuthenticationRoutes.Home
    ) {
        composable<AuthenticationRoutes.Home> {
            HomeAuthenticationScreen(
                navigateToLoginScreen = {
                    navHostController.navigate(AuthenticationRoutes.Login)
                },
                navigateToSignupScreen = {
                    navHostController.navigate(AuthenticationRoutes.Signup)
                }
            )
        }
        composable<AuthenticationRoutes.Login> {
            LoginScreen(
                navigateToSignupScreen = {
                    navHostController.navigate(AuthenticationRoutes.Signup) {
                        popUpTo(AuthenticationRoutes.Login) {
                            inclusive = true
                        }
                    }
                },
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }
        composable<AuthenticationRoutes.Signup> {
            SignupScreen(
                navigateToLoginScreen = {
                    navHostController.navigate(AuthenticationRoutes.Login) {
                        popUpTo(AuthenticationRoutes.Signup) {
                            inclusive = true
                        }
                    }
                },
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }
    }
}