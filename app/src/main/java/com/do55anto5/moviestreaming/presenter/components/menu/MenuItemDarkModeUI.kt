package com.do55anto5.moviestreaming.presenter.components.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.do55anto5.moviestreaming.R
import com.do55anto5.moviestreaming.presenter.components.switch.SwitchUI
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme
import com.do55anto5.moviestreaming.presenter.theme.UrbanistFamily

@Composable
fun MenuItemDarkModeUI(
    modifier: Modifier = Modifier,
    icon: Int,
    label: Int,
    isDarkMode: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(28.dp),
            tint = MovieStreamingTheme.colorScheme.iconColor
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = stringResource(id = label),
            modifier = Modifier
                .weight(1f),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = UrbanistFamily,
                fontWeight = FontWeight.SemiBold,
                color = MovieStreamingTheme.colorScheme.textColor,
                letterSpacing = 0.2.sp
            )
        )

        SwitchUI(
            checked = isDarkMode,
            onCheckedChange = { checked ->
                onCheckedChange(checked)
            }
        )
    }
}

@Preview
@Composable
private fun MenuItemDarkModeUIPreview() {
    MovieStreamingTheme(isDarkTheme = false) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MovieStreamingTheme.colorScheme.primaryBackgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MenuItemDarkModeUI(
                icon =  R.drawable.ic_dark_mode,
                label = R.string.label_theme_mode_account_screen,
                isDarkMode = true,
                onCheckedChange = {}
            )
        }
    }
}