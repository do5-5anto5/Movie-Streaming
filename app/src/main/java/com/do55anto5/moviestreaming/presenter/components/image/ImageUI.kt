package com.do55anto5.moviestreaming.presenter.components.image


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.do55anto5.moviestreaming.R
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ImageUI(
    modifier: Modifier = Modifier,
    imageModel: Any? = null,
    previewPlaceholder: Painter? = null,
    contentScale: ContentScale = ContentScale.None,
    shape: Shape = RoundedCornerShape(12.dp),
    borderStroke: BorderStroke = BorderStroke(0.dp, MovieStreamingTheme.colorScheme.transparentColor),
    isLoading: Boolean = false,
    onClick: () -> Unit = {}
) {
    val failureComposition by rememberLottieComposition(LottieCompositionSpec.Asset("error_loading_error.json"))

    CoilImage(
        imageModel = { imageModel },
        modifier = modifier
            .clip(shape = shape)
            .clickable{ onClick() }
            .border(borderStroke,shape = shape),
        imageOptions = ImageOptions(
            contentScale = contentScale,
            alignment = Alignment.Center
        ),
        previewPlaceholder = previewPlaceholder,
        loading = {
               Box(
                   modifier = Modifier
                       .fillMaxSize()
                       .background(MovieStreamingTheme.colorScheme.primaryBackgroundColor),
                   content = {
                       CircularProgressIndicator(
                           modifier = Modifier
                               .align(Alignment.Center),
                           color = MovieStreamingTheme.colorScheme.defaultColor
                       )
                   }
               )
        },
        failure = {
            if (!isLoading) {
                LottieAnimation(
                    composition = failureComposition,
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.BottomCenter),
                    iterations = LottieConstants.IterateForever,
                    maintainOriginalImageBounds = true
                )
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun ImageUIPreview() {
    MovieStreamingTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MovieStreamingTheme.colorScheme.primaryBackgroundColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageUI(
                modifier = Modifier
                    .size(200.dp),
                imageModel = "https://img.freepik.com/fotos-gratis/astronomia-do-ceu-noturno-galactico-e-ciencia-combinaram-ia-generativa_188544-9656.jpg",
                contentScale = ContentScale.Crop,
                previewPlaceholder = painterResource(id = R.drawable.placeholder_welcome),
                borderStroke = BorderStroke(2.dp, MovieStreamingTheme.colorScheme.defaultColor),
                onClick = {}
            )
        }
    }
}