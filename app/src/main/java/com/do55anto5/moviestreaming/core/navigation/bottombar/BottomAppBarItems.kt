package com.do55anto5.moviestreaming.core.navigation.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.do55anto5.moviestreaming.R

sealed class BottomAppBarItems(
    val route: String,
    @StringRes val label: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
) {

    data object Home : BottomAppBarItems(
        route = "home",
        label = R.string.label_home_bottom_app_bar,
        selectedIcon = R.drawable.ic_home_fill,
        unselectedIcon = R.drawable.ic_home_line
    )

    data object Search : BottomAppBarItems(
        route = "search",
        label = R.string.label_search_bottom_app_bar,
        selectedIcon = R.drawable.ic_search_fill,
        unselectedIcon = R.drawable.ic_search_line
    )

    data object Favorite : BottomAppBarItems(
        route = "favorite",
        label = R.string.label_favorite_bottom_app_bar,
        selectedIcon = R.drawable.ic_heart_fill,
        unselectedIcon = R.drawable.ic_heart_line
    )

    data object Download : BottomAppBarItems(
        route = "download",
        label = R.string.label_download_bottom_app_bar,
        selectedIcon = R.drawable.ic_download_fill,
        unselectedIcon = R.drawable.ic_download_line
    )

    data object Account : BottomAppBarItems(
        route = "account",
        label = R.string.label_account_bottom_app_bar,
        selectedIcon = R.drawable.ic_user_line,
        unselectedIcon = R.drawable.ic_user_fill
    )

    companion object {
        val items = listOf(
            Home,
            Search,
            Favorite,
            Download,
            Account
        )
    }

    enum class ItemType {
        HOME,
        SEARCH,
        FAVORITE,
        DOWNLOAD,
        ACCOUNT
    }

}