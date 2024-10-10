package com.do55anto5.moviestreaming.core.navigation.hosts.onboarding

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.do55anto5.moviestreaming.core.navigation.hosts.app.appNavHost
import com.do55anto5.moviestreaming.core.navigation.hosts.authentication.authenticationNavHost
import com.do55anto5.moviestreaming.core.navigation.routes.authentication.AuthenticationRoutes
import com.do55anto5.moviestreaming.core.navigation.routes.onboarding.OnboardingRoutes
import com.do55anto5.moviestreaming.presenter.screens.splash.SplashScreen
import com.do55anto5.moviestreaming.presenter.screens.welcome.WelcomeScreen

@Composable
fun OnboardingNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = OnboardingRoutes.Splash
    ) {
        composable<OnboardingRoutes.Splash> {
            SplashScreen(
                navigateToWelcomeScreen = {
                    navHostController.navigate(OnboardingRoutes.Welcome) {
                        popUpTo(OnboardingRoutes.Splash) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable<OnboardingRoutes.Welcome> {
            WelcomeScreen(
                navigateToHomeAuthenticationScreen = {
                    navHostController.navigate(AuthenticationRoutes.Graph) {
                        popUpTo(OnboardingRoutes.Welcome) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        authenticationNavHost(navHostController = navHostController)
        appNavHost()
    }
}