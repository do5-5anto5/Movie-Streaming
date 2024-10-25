package com.do55anto5.moviestreaming.presenter.components.header


import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.do55anto5.moviestreaming.R
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme
import com.do55anto5.moviestreaming.presenter.theme.UrbanistFamily

@Composable
fun HeaderScreen(
    modifier: Modifier,
    @StringRes title: Int
) {
    Row(
        modifier =  Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        content = {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = stringResource(title),
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 28.8.sp,
                    fontFamily = UrbanistFamily,
                    fontWeight = FontWeight.Bold,
                    color = MovieStreamingTheme.colorScheme.textColor
                )
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun HeaderScreenPreview() {
    MovieStreamingTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MovieStreamingTheme.colorScheme.backgroundColor)
                .padding(24.dp),
            content = {
                HeaderScreen(
                    modifier = Modifier,
                    title = R.string.app_name
                )
            }
        )
    }
}