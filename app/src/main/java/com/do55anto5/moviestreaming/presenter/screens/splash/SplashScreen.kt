package com.do55anto5.moviestreaming.presenter.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.do55anto5.moviestreaming.R
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navigateToWelcomeScreen: () -> Unit
) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        scope.launch {
            delay(2000)
            navigateToWelcomeScreen()
        }
    }

    SplashContent(
        navigateToWelcomeScreen = navigateToWelcomeScreen
    )

}

@Composable
private fun SplashContent(
    navigateToWelcomeScreen: () -> Unit
) {

    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("loading.json"))

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MovieStreamingTheme.colorScheme.backgroundColor,
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(vertical = 100.dp),
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )

                    LottieAnimation(
                        composition = composition,
                        modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.BottomCenter),
                        iterations = LottieConstants.IterateForever,
                        maintainOriginalImageBounds = true
                    )
                }
            )
        }
    )
}

@Preview
@Composable
private fun SplashScreenView() {
    SplashContent(
        navigateToWelcomeScreen = {}
    )
}