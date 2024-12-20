package com.do55anto5.moviestreaming.presenter.screens.authentication.login.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.do55anto5.moviestreaming.R
import com.do55anto5.moviestreaming.core.enums.input.InputType
import com.do55anto5.moviestreaming.presenter.components.button.PrimaryButton
import com.do55anto5.moviestreaming.presenter.components.button.SocialButton
import com.do55anto5.moviestreaming.presenter.components.divider.HorizontalDividerWithText
import com.do55anto5.moviestreaming.presenter.components.editText.TextFieldUI
import com.do55anto5.moviestreaming.presenter.components.snackbar.FeedbackUI
import com.do55anto5.moviestreaming.presenter.components.topAppBar.TopAppBarUI
import com.do55anto5.moviestreaming.presenter.screens.authentication.login.action.LoginAction
import com.do55anto5.moviestreaming.presenter.screens.authentication.login.state.LoginState
import com.do55anto5.moviestreaming.presenter.screens.authentication.login.viewmodel.LoginViewModel
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme
import com.do55anto5.moviestreaming.presenter.theme.UrbanistFamily
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    navigateToSignupScreen: () -> Unit,
    navigateToAppScreen: () -> Unit,
    onBackPressed: () -> Unit
) {

    val viewModel = koinViewModel<LoginViewModel>()
    val state by viewModel.state.collectAsState()

    with (state) {
        LaunchedEffect(isLoading, isAuthenticated) {
            if (!isLoading) {
                if(isAuthenticated) {
                    navigateToAppScreen()
                }
            }
        }
    }

    LoginContent(
        state = state,
        action = viewModel::submitAction,
        navigateToSignupScreen = navigateToSignupScreen,
        onBackPressed = onBackPressed
    )
}

@Composable
private fun LoginContent(
    state: LoginState = LoginState(),
    action: (LoginAction) -> Unit,
    navigateToSignupScreen: () -> Unit,
    onBackPressed: () -> Unit
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.hasFeedback) {
        if (state.hasFeedback) {
            scope.launch {
                val result = snackbarHostState
                    .showSnackbar(
                        message = context.getString(
                            state.feedbackUI?.second ?: R.string.error_generic
                        )
                    )

                if (result == SnackbarResult.Dismissed) {
                    action(LoginAction.ResetErrorState)
                }

            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBarUI(
                onClick = { onBackPressed() }
            )
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = { snackbarData ->
                    state.feedbackUI?.let { feedbackUI ->
                        FeedbackUI(
                            message = snackbarData.visuals.message,
                            type = feedbackUI.first
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MovieStreamingTheme.colorScheme.primaryBackgroundColor)
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp, vertical = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                    )

                    Spacer(Modifier.height(48.dp))

                    Text(
                        text = stringResource(R.string.label_title_login_screen),
                        style = TextStyle(
                            fontSize = 32.sp,
                            lineHeight = 38.4.sp,
                            fontFamily = UrbanistFamily,
                            fontWeight = FontWeight.Bold,
                            color = MovieStreamingTheme.colorScheme.textColor,
                            textAlign = TextAlign.Center
                        )
                    )

                    Spacer(Modifier.height(48.dp))

                    // EMAIL INPUT FIELD
                    TextFieldUI(
                        modifier = Modifier,
                        value = state.email,
                        label = stringResource(R.string.label_input_email_login_screen),
                        placeholder = stringResource(R.string.placeholder_input_email_login_screen),
                        mLeadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_email_fill),
                                contentDescription = null,
                                tint = MovieStreamingTheme.colorScheme.greyscale500Color
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        onValueChange = {
                            action(
                                LoginAction.OnValueChange(
                                    value = it,
                                    type = InputType.EMAIL
                                )
                            )
                        }
                    )

                    Spacer(Modifier.height(20.dp))

                    // PASSWORD INPUT FIELD
                    TextFieldUI(
                        modifier = Modifier,
                        value = state.password,
                        label = stringResource(R.string.label_input_password_login_screen),
                        placeholder = stringResource(R.string.placeholder_input_password_login_screen),
                        // PASSWORD MASK
                        visualTransformation =
                        if (state.passwordVisibility) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        mLeadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_password_mine),
                                contentDescription = null,
                                tint = MovieStreamingTheme.colorScheme.greyscale500Color
                            )
                        },
                        mTrailingIcon = {
                            if (state.password.isNotEmpty()) {
                                IconButton(
                                    onClick = {
                                        action(LoginAction.OnPasswordVisibilityChange)
                                    },
                                    content = {
                                        Icon(
                                            painter =
                                            if (state.passwordVisibility) {
                                                painterResource(R.drawable.ic_hide)
                                            } else {
                                                painterResource(R.drawable.ic_show)
                                            },
                                            contentDescription = null,
                                        )
                                    }
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Done
                        ),
                        onValueChange = {
                            action(
                                LoginAction.OnValueChange(
                                    value = it,
                                    type = InputType.PASSWORD
                                )
                            )
                        }
                    )

                    Spacer(Modifier.height(20.dp))

                    PrimaryButton(
                        text = stringResource(R.string.label_button_login_screen),
                        isLoading = false,
                        enabled = state.enableSignInButton,
                        onClick = { action(LoginAction.OnSignIn) }
                    )

                    Spacer(Modifier.height(20.dp))

                    Text(
                        text = stringResource(R.string.label_forgot_password_login_screen),
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.4.sp,
                            fontFamily = UrbanistFamily,
                            fontWeight = FontWeight.Bold,
                            color = MovieStreamingTheme.colorScheme.defaultColor,
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.2.sp
                        )
                    )

                    Spacer(Modifier.height(20.dp))

                    HorizontalDividerWithText(
                        text = stringResource(R.string.label_or_login_screen)
                    )

                    Spacer(Modifier.height(20.dp))

                    // SOCIAL BUTTONS
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        content = {
                            SocialButton(
                                icon = painterResource(id = R.drawable.ic_google),
                                onClick = {}
                            )

                            Spacer(modifier = Modifier.width(20.dp))

                            SocialButton(
                                icon = painterResource(id = R.drawable.ic_facebook),
                                onClick = {}
                            )

                            Spacer(modifier = Modifier.width(20.dp))

                            SocialButton(
                                icon = painterResource(id = R.drawable.ic_github),
                                onClick = {}
                            )
                        }
                    )

                    Spacer(Modifier.height(24.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        content = {
                            Text(
                                text = stringResource(id = R.string.label_sign_up_account_login_screen),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 19.6.sp,
                                    fontFamily = UrbanistFamily,
                                    color = MovieStreamingTheme.colorScheme.textColor,
                                    textAlign = TextAlign.Right,
                                    letterSpacing = 0.2.sp
                                )
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                modifier = Modifier
                                    .clickable { navigateToSignupScreen() },
                                text = stringResource(id = R.string.label_sign_up_login_screen),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 19.6.sp,
                                    fontFamily = UrbanistFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MovieStreamingTheme.colorScheme.defaultColor,
                                    textAlign = TextAlign.Right,
                                    letterSpacing = 0.2.sp
                                )
                            )
                        }
                    )
                }
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun LoginScreenPreview() {
    MovieStreamingTheme {

        LoginContent(
            state = LoginState(),
            action = {},
            navigateToSignupScreen = {},
            onBackPressed = {}
        )
    }
}