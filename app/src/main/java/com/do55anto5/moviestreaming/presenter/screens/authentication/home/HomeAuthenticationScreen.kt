package com.do55anto5.moviestreaming.presenter.screens.authentication.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.do55anto5.moviestreaming.R
import com.do55anto5.moviestreaming.presenter.components.button.PrimaryButton
import com.do55anto5.moviestreaming.presenter.components.button.SocialButton
import com.do55anto5.moviestreaming.presenter.components.divider.HorizontalDividerWithText
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme
import com.do55anto5.moviestreaming.presenter.theme.UrbanistFamily

@Composable
fun HomeAuthenticationScreen() {
    HomeAuthenticationContent()
}

@Composable
fun HomeAuthenticationContent() {
    Scaffold(
        containerColor = MovieStreamingTheme.colorScheme.backgroundColor,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.placeholder_home_authentication),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = stringResource(id = R.string.label_title_authentication_screen),
                        style = TextStyle(
                            fontSize = 48.sp,
                            lineHeight = 57.6.sp,
                            fontFamily = UrbanistFamily,
                            fontWeight = FontWeight.Bold,
                            color = MovieStreamingTheme.colorScheme.textColor,
                            textAlign = TextAlign.Center
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    SocialButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        icon = painterResource(id = R.drawable.ic_google),
                        isLoading = false,
                        text = "Continue with Google",
                        onClick = {}
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    SocialButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        icon = painterResource(id = R.drawable.ic_facebook),
                        isLoading = false,
                        text = "Continue with Facebook",
                        onClick = {}
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    SocialButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        icon = painterResource(id = R.drawable.ic_github),
                        isLoading = false,
                        text = "Continue with Github",
                        onClick = {}
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    HorizontalDividerWithText(
                        text = stringResource(id = R.string.label_or_authentication_screen)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    PrimaryButton(
                        text = stringResource(id = R.string.label_sign_with_password_authentication_screen),
                        isLoading = false,
                        onClick = {}
                    )
                }
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun HomeAuthenticationScreenPreview() {
    MovieStreamingTheme {
        HomeAuthenticationContent()
    }
}