package com.do55anto5.moviestreaming.presenter.components.bottom.sheet.drag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun DragBottomSheet() {
    Spacer(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 24.dp)
            .clip(CircleShape)
            .width(38.dp)
            .height(2.dp)
            .background(MovieStreamingTheme.colorScheme.greyscale300Color)
    )
}

@PreviewLightDark
@Composable
private fun DragBottomSheetPreview() {
    MovieStreamingTheme{
        DragBottomSheet()
    }
}