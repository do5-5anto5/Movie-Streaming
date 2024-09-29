package com.do55anto5.moviestreaming.presenter.screens.main.download.screen


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.do55anto5.moviestreaming.presenter.screens.main.download.action.DownloadAction
import com.do55anto5.moviestreaming.presenter.screens.main.download.state.DownloadState
import com.do55anto5.moviestreaming.presenter.screens.main.download.viewmodel.DownloadViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DownloadScreen() {
    val viewModel = koinViewModel<DownloadViewModel>()
    val state by viewModel.state.collectAsState()

    DownloadContent(
        state = state,
        action = viewModel::submitAction
    )
}

@Composable
private fun DownloadContent(
    state: DownloadState,
    action: (DownloadAction) -> Unit
) {
}

@PreviewLightDark
@Composable
private fun DownloadScreenPreview() {
    DownloadContent(
        state = DownloadState(),
        action = {}
    )
}