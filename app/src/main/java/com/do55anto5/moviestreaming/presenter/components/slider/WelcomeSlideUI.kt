package com.do55anto5.moviestreaming.presenter.components.slider


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.do55anto5.moviestreaming.R
import com.do55anto5.moviestreaming.presenter.components.indicator.SlideIndicatorUI
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme
import com.do55anto5.moviestreaming.presenter.theme.UrbanistFamily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeSlideUI(
    modifier: Modifier = Modifier,
    slideItems: List<Pair<String, String>>,
    pagerState: PagerState
) {

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {

            HorizontalPager(
                state = pagerState,
                Modifier
                    .fillMaxSize()
                    .weight(1f),
                pageContent = {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom,
                        content = {
                            Text(
                                text = slideItems[pagerState.currentPage].first,
                                style = TextStyle(
                                    fontSize = 40.sp,
                                    lineHeight = 48.sp,
                                    fontFamily = UrbanistFamily,
                                    fontWeight = FontWeight.Bold,
                                    color = MovieStreamingTheme.colorScheme.whiteColor,
                                    textAlign = TextAlign.Center
                                )
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            Text(
                                text = slideItems[pagerState.currentPage].second,
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    lineHeight = 26.2.sp,
                                    fontFamily = UrbanistFamily,
                                    fontWeight = FontWeight.Medium,
                                    color = MovieStreamingTheme.colorScheme.whiteColor,
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.2.sp
                                )
                            )
                        }
                    )
                }
            )

            SlideIndicatorUI(
                modifier = Modifier
                    .padding(bottom = 24.dp),
                totalIndicators = slideItems.size,
                currentIndicator = pagerState.currentPage
            )
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun WelcomeSlideUIPreview() {
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

    WelcomeSlideUI(
        slideItems = slideItems,
        pagerState = pagerState
    )
}