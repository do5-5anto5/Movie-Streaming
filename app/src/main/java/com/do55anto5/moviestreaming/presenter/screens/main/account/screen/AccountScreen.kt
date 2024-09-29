package com.do55anto5.moviestreaming.presenter.screens.main.account.screen


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.do55anto5.moviestreaming.presenter.screens.main.account.action.AccountAction
import com.do55anto5.moviestreaming.presenter.screens.main.account.state.AccountState
import com.do55anto5.moviestreaming.presenter.screens.main.account.viewmodel.AccountViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AccountScreen() {
    val viewModel = koinViewModel<AccountViewModel>()
    val state by viewModel.state.collectAsState()

    AccountContent(
        state = state,
        action = viewModel::submitAction
    )
}

@Composable
private fun AccountContent(
    state: AccountState,
    action: (AccountAction) -> Unit
) {
}

@PreviewLightDark
@Composable
private fun AccountScreenPreview() {
    AccountContent(
        state = AccountState(),
        action = {}
    )
}