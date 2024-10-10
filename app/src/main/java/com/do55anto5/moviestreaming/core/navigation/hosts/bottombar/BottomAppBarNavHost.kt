package com.do55anto5.moviestreaming.core.navigation.hosts.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.do55anto5.moviestreaming.core.navigation.bottombar.BottomAppBarItems
import com.do55anto5.moviestreaming.presenter.screens.main.account.screen.AccountScreen
import com.do55anto5.moviestreaming.presenter.screens.main.download.screen.DownloadScreen
import com.do55anto5.moviestreaming.presenter.screens.main.favorite.screen.FavoriteScreen
import com.do55anto5.moviestreaming.presenter.screens.main.home.screen.HomeScreen
import com.do55anto5.moviestreaming.presenter.screens.main.search.screen.SearchScreen

@Composable
fun BottomAppBarNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomAppBarItems.Home
    ) {
        composable<BottomAppBarItems.Home> {
            HomeScreen()
        }

        composable<BottomAppBarItems.Search> {
            SearchScreen()
        }

        composable<BottomAppBarItems.Favorite> {
            FavoriteScreen()
        }

        composable<BottomAppBarItems.Download> {
            DownloadScreen()
        }

        composable<BottomAppBarItems.Account> {
            AccountScreen()
        }

    }
}
