@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.do55anto5.moviestreaming.presenter.screens.main.account.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.do55anto5.moviestreaming.R
import com.do55anto5.moviestreaming.core.enums.menu.MenuType.DARK_MODE
import com.do55anto5.moviestreaming.core.enums.menu.MenuType.DOWNLOAD
import com.do55anto5.moviestreaming.core.enums.menu.MenuType.EDIT_PROFILE
import com.do55anto5.moviestreaming.core.enums.menu.MenuType.HELP_CENTER
import com.do55anto5.moviestreaming.core.enums.menu.MenuType.LANGUAGE
import com.do55anto5.moviestreaming.core.enums.menu.MenuType.LOGOUT
import com.do55anto5.moviestreaming.core.enums.menu.MenuType.NOTIFICATION
import com.do55anto5.moviestreaming.core.enums.menu.MenuType.PRIVACY_POLICY
import com.do55anto5.moviestreaming.core.enums.menu.MenuType.SECURITY
import com.do55anto5.moviestreaming.domain.remote.model.User
import com.do55anto5.moviestreaming.presenter.components.bottom.sheet.BottomSheetLogout
import com.do55anto5.moviestreaming.presenter.components.bottom.sheet.drag.DragBottomSheet
import com.do55anto5.moviestreaming.presenter.components.header.HeaderScreen
import com.do55anto5.moviestreaming.presenter.components.image.ImageUI
import com.do55anto5.moviestreaming.presenter.components.menu.MenuItemDarkModeUI
import com.do55anto5.moviestreaming.presenter.components.menu.MenuItemLanguageUI
import com.do55anto5.moviestreaming.presenter.components.menu.MenuItemUI
import com.do55anto5.moviestreaming.presenter.components.menu.MenuItems
import com.do55anto5.moviestreaming.presenter.screens.main.account.action.AccountAction
import com.do55anto5.moviestreaming.presenter.screens.main.account.state.AccountState
import com.do55anto5.moviestreaming.presenter.screens.main.account.viewmodel.AccountViewModel
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme
import com.do55anto5.moviestreaming.presenter.theme.UrbanistFamily
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun AccountScreen() {
    val viewModel = koinViewModel<AccountViewModel>()
    val state by viewModel.state.collectAsState()

    AccountContent(
        state = state,
        action = viewModel::submitAction,
        onItemClick = { menu ->
            when (menu.type) {
                EDIT_PROFILE -> {}
                NOTIFICATION -> {}
                DOWNLOAD -> {}
                SECURITY -> {}
                LANGUAGE -> {}
                DARK_MODE -> {}
                HELP_CENTER -> {}
                PRIVACY_POLICY -> {}
                LOGOUT -> {}
            }
        }
    )
}

@Composable
private fun AccountContent(
    state: AccountState,
    action: (AccountAction) -> Unit,
    onItemClick: (MenuItems) -> Unit
) {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            HeaderScreen(
                modifier = Modifier
                    .padding(
                        top = 24.dp,
                        start = 24.dp,
                        end = 24.dp
                    ),
                title = R.string.label_account_bottom_app_bar
            )
        },
        containerColor = MovieStreamingTheme.colorScheme.primaryBackgroundColor,
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding()
                    ),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    ImageUI(
                        modifier = Modifier
                            .size(200.dp),
                        imageModel = state.user?.photo,
                        contentScale = ContentScale.Crop,
                        previewPlaceholder = painterResource(id = R.drawable.placeholder_welcome),
                        shape = CircleShape,
                        isLoading = state.isLoading
                    )

                    Spacer(modifier = Modifier.size(12.dp))

                    if (state.user?.name?.isNotEmpty() == true &&
                        state.user.surname?.isNotEmpty() == true
                    ) {
                        Text(
                            text = "${state.user.name} ${state.user.surname}",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 24.sp,
                                fontFamily = UrbanistFamily,
                                fontWeight = FontWeight.Bold,
                                color = MovieStreamingTheme.colorScheme.textColor,
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    Spacer(modifier = Modifier.size(12.dp))

                    if (state.user?.email?.isNotEmpty() == true) {
                        Text(
                            text = state.user.email,
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 19.6.sp,
                                fontFamily = UrbanistFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = MovieStreamingTheme.colorScheme.textColor,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
                items(MenuItems.items()) { item ->
                    when (item.type) {
                        LANGUAGE -> {
                            MenuItemLanguageUI(
                                icon = item.icon,
                                label = item.label,
                                onClick = { onItemClick(item) }
                            )
                        }

                        DARK_MODE -> {
                            MenuItemDarkModeUI(
                                icon = item.icon,
                                label = item.label,
                                isDarkMode = false,
                                onCheckedChange = { onItemClick(item) }
                            )
                        }

                        else -> {
                            MenuItemUI(
                                icon = item.icon,
                                label = item.label,
                                onClick = {
                                    if (item.type == LOGOUT) {
                                        showBottomSheet = true
                                    } else {
                                        onItemClick(item)
                                    }
                                }
                            )
                        }
                    }
                }
            }

            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState,
                    containerColor = MovieStreamingTheme.colorScheme.secondaryBackgroundColor,
                    dragHandle = {
                        DragBottomSheet()
                    }
                    ) {
                    BottomSheetLogout(
                        onCancelClick = {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                }
                            }
                        },
                        onLogoutClick = {}
                    )
                }
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun AccountScreenPreview() {
    AccountContent(
        state = AccountState(
            user = User(
                name = "Mock Name",
                surname = " Surname",
                email = "mock@email.com"
            )
        ),
        action = {},
        onItemClick = {}
    )
}