package com.do55anto5.moviestreaming.core.navigation.routes.app

import kotlinx.serialization.Serializable

sealed class AppRoutes {
    @Serializable
    data object Graph : AppRoutes()

    @Serializable
    data object App : AppRoutes()
}