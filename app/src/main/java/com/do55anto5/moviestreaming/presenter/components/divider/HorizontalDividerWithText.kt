package com.do55anto5.moviestreaming.presenter.components.divider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.do55anto5.moviestreaming.R
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme
import com.do55anto5.moviestreaming.presenter.theme.UrbanistFamily

@Composable
fun HorizontalDividerWithText(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(modifier = Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        content = {
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f),
                color = MovieStreamingTheme.colorScheme.dividerColor
            )

            Text(
                text = stringResource(id = R.string.label_or_authentication_screen),
                modifier = modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.2.sp,
                    fontFamily = UrbanistFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = MovieStreamingTheme.colorScheme.textColor,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.2.sp
                )
            )

            HorizontalDivider(
                modifier = Modifier
                    .weight(1f),
                color = MovieStreamingTheme.colorScheme.dividerColor
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun HorizontalDividerWithTextPreview() {
    MovieStreamingTheme {
        Column(
            modifier = Modifier
                .background(MovieStreamingTheme.colorScheme.backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalDividerWithText(
                text = "ou"
            )
        }
    }
}