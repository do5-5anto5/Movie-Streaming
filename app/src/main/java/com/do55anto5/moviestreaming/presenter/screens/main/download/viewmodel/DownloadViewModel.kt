package com.do55anto5.moviestreaming.presenter.screens.main.download.viewmodel


import androidx.lifecycle.ViewModel
import com.do55anto5.moviestreaming.presenter.screens.main.download.action.DownloadAction
import com.do55anto5.moviestreaming.presenter.screens.main.download.state.DownloadState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DownloadViewModel : ViewModel() {

    private val _state = MutableStateFlow(DownloadState())
    val state = _state.asStateFlow()

    fun submitAction(action: DownloadAction) {

    }

}