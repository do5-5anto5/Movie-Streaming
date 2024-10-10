package com.do55anto5.moviestreaming.core.navigation.hosts.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.do55anto5.moviestreaming.core.navigation.routes.app.AppRoutes
import com.do55anto5.moviestreaming.presenter.screens.main.app.screen.AppScreen

fun NavGraphBuilder.appNavHost() {
    navigation<AppRoutes.Graph>(
        startDestination = AppRoutes.Graph
    ) {
        composable<AppRoutes.App> {
            AppScreen()
        }
    }
}