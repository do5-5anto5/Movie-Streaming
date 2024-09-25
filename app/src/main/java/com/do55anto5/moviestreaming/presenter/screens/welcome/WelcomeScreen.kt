package com.do55anto5.moviestreaming.presenter.screens.welcome


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.do55anto5.moviestreaming.R
import com.do55anto5.moviestreaming.presenter.components.button.PrimaryButton
import com.do55anto5.moviestreaming.presenter.components.slider.WelcomeSlideUI
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun WelcomeScreen(
    navigateToHomeAuthenticationScreen: () -> Unit
) {
    WelcomeContent(
        navigateToHomeAuthenticationScreen = navigateToHomeAuthenticationScreen
    )
}

@Composable
fun WelcomeContent(
    navigateToHomeAuthenticationScreen: () -> Unit
) {

    val slideItems = listOf(
        Pair(
            stringResource(id = R.string.welcome_slider_title),
            stringResource(id = R.string.welcome_slider_slide1)
        ),
        Pair(
            stringResource(id = R.string.welcome_slider_title),
            stringResource(id = R.string.welcome_slider_slide2)
        ),
        Pair(
            stringResource(id = R.string.welcome_slider_title),
            stringResource(id = R.string.welcome_slider_slide3)
        )
    )
    val pagerState = rememberPagerState {
        slideItems.size
    }

    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        content = { paddingValues ->

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
                .background(MovieStreamingTheme.colorScheme.backgroundColor),
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.placeholder_welcome),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Image(
                        painter = painterResource(id = R.drawable.background_gradient),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        content = {

                            WelcomeSlideUI(
                                modifier = Modifier
                                    .weight(1f),
                                slideItems = slideItems,
                                pagerState = pagerState
                            )

                            PrimaryButton(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
                                text = stringResource(id = R.string.welcome_button_continue),
                                isLoading = false,
                                onClick = { navigateToHomeAuthenticationScreen() }
                            )
                        }
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    WelcomeContent( navigateToHomeAuthenticationScreen = {} )
}