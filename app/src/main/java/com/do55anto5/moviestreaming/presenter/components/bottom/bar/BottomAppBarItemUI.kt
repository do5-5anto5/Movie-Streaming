package com.do55anto5.moviestreaming.presenter.components.bottom.bar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.do55anto5.moviestreaming.core.helper.NoRippleInteractionSource
import com.do55anto5.moviestreaming.core.navigation.bottombar.BottomAppBarItem
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun RowScope.BottomAppBarItemUI(
    modifier: Modifier = Modifier,
    item: BottomAppBarItem,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = onClick,
        icon = {
            if (isSelected) {
                Icon(
                    painter = painterResource(item.selectedIcon),
                    contentDescription = stringResource(item.label),
                    tint = MovieStreamingTheme.colorScheme.defaultColor
                )
            } else {
                Icon(
                    painter = painterResource(item.unselectedIcon),
                    contentDescription = stringResource(item.label),
                    tint = MovieStreamingTheme.colorScheme.greyscale500Color
                )
            }
        },
        modifier = modifier,
        label = {
            Text(
                text = stringResource(item.label),
                color = if (isSelected) {
                    MovieStreamingTheme.colorScheme.defaultColor
                } else {
                    MovieStreamingTheme.colorScheme.greyscale500Color
                }
            )
        },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = MovieStreamingTheme.colorScheme.transparentColor
        ),
        interactionSource = NoRippleInteractionSource()
    )
}

@PreviewLightDark
@Composable
private fun BottomAppBarItemUIPreview() {
    MovieStreamingTheme {
        BottomAppBar(
            actions = {
                BottomAppBarItem.items.forEach { item ->
                    BottomAppBarItemUI(
                        item = item,
                        isSelected = item == BottomAppBarItem.Home,
                        onClick = {}
                    )
                }
            },
            modifier = Modifier,
            containerColor = MovieStreamingTheme.colorScheme.primaryBackgroundColor
        )
    }
}