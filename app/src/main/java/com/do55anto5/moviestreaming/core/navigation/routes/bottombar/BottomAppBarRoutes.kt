package com.do55anto5.moviestreaming.core.navigation.routes.bottombar

import kotlinx.serialization.Serializable

sealed class BottomAppBarRoutes {

    @Serializable
    data object Home : BottomAppBarRoutes()
    @Serializable
    data object Search : BottomAppBarRoutes()
    @Serializable
    data object Profile : BottomAppBarRoutes()
    @Serializable
    data object Favorite : BottomAppBarRoutes()
    @Serializable
    data object Download : BottomAppBarRoutes()
    @Serializable
    data object Account : BottomAppBarRoutes()

}