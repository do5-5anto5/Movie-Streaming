package com.do55anto5.moviestreaming.core.navigation.hosts.bottombar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.do55anto5.moviestreaming.core.navigation.routes.bottombar.BottomAppBarRoutes
import com.do55anto5.moviestreaming.presenter.screens.main.account.screen.AccountScreen
import com.do55anto5.moviestreaming.presenter.screens.main.download.screen.DownloadScreen
import com.do55anto5.moviestreaming.presenter.screens.main.favorite.screen.FavoriteScreen
import com.do55anto5.moviestreaming.presenter.screens.main.home.screen.HomeScreen
import com.do55anto5.moviestreaming.presenter.screens.main.search.screen.SearchScreen

@Composable
fun BottomAppBarNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomAppBarRoutes.Home,
        modifier = modifier
    ) {
        composable<BottomAppBarRoutes.Home> {
            HomeScreen()
        }

        composable<BottomAppBarRoutes.Search> {
            SearchScreen()
        }

        composable<BottomAppBarRoutes.Favorite> {
            FavoriteScreen()
        }

        composable<BottomAppBarRoutes.Download> {
            DownloadScreen()
        }

        composable<BottomAppBarRoutes.Account> {
            AccountScreen()
        }

    }
}
