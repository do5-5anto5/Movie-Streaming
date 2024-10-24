package com.do55anto5.moviestreaming.presenter.components.switch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun SwitchUI(
    modifier: Modifier = Modifier,
    checked: Boolean,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        enabled = enabled,
        colors = SwitchDefaults.colors(
            checkedThumbColor = MovieStreamingTheme.colorScheme.whiteColor,
            uncheckedThumbColor = MovieStreamingTheme.colorScheme.whiteColor,
            checkedTrackColor = MovieStreamingTheme.colorScheme.defaultColor,
            uncheckedTrackColor = MovieStreamingTheme.colorScheme.switchColor,
            checkedBorderColor = MovieStreamingTheme.colorScheme.defaultColor,
            uncheckedBorderColor = MovieStreamingTheme.colorScheme.switchColor
        ),
        modifier = modifier
    )
}

@Preview
@Composable
private fun SwitchUIPreview() {
    var switchState by remember {
        mutableStateOf(false)
    }

    MovieStreamingTheme(isDarkTheme = false) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MovieStreamingTheme.colorScheme.backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SwitchUI(
                checked = switchState,
                onCheckedChange = { checked ->
                    switchState = checked
                }
            )
        }
    }
}