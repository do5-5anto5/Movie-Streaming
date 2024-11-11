package com.do55anto5.moviestreaming.presenter.components.bottom.bar


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.do55anto5.moviestreaming.core.navigation.bottombar.BottomAppBarItem
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun BottomBarUI(
    modifier: Modifier = Modifier,
    currentDestination: NavDestination?,
    onItemClick: (BottomAppBarItem) -> Unit
) {
    BottomAppBar(
        actions = {
            BottomAppBarItem.items.forEach { item ->
                val isSelected = currentDestination?.hierarchy?.any {
                    it.route == item.route::class.qualifiedName
                } == true
                BottomAppBarItemUI(
                    item = item,
                    isSelected = isSelected,
                    onClick = { onItemClick(item) }
                )
            }
        },
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        containerColor = MovieStreamingTheme.colorScheme.primaryBackgroundColor
    )
}
