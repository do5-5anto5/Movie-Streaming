package com.do55anto5.moviestreaming.presenter.screens.main.app.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.do55anto5.moviestreaming.core.navigation.hosts.bottombar.BottomAppBarNavHost
import com.do55anto5.moviestreaming.presenter.components.bottom_bar.BottomBarUI
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun AppScreen() {
    AppContent()
}

@Composable
private fun AppContent() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomBarUI(
                currentDestination = currentDestination,
                onItemClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },
        content = { paddingValues ->
            BottomAppBarNavHost(
             modifier = Modifier
                 .background(MovieStreamingTheme.colorScheme.primaryBackgroundColor)
                 .padding(paddingValues),
             navHostController = navController
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun AppScreenPreview() {
    MovieStreamingTheme {
        AppContent()
    }
}