package com.do55anto5.moviestreaming.presenter.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

private val LightColorScheme = MyColorScheme(
    defaultColor = DefaultColor,
    alphaDefaultColor = AlphaDefaultColor,
    disabledDefaultColor = DisabledDefaultColor,
    primaryBackgroundColor = PrimaryBackgroundColorLight,
    secondaryBackgroundColor = SecondaryBackgroundColorLight,
    borderColor = BorderColorLight,
    dividerColor = DividerColorLight,
    topAppBarColor = TopAppBarColorLight,
    textFieldBackGroundColor = TextFieldBackGroundColorLight,
    backgroundSocialButtonColor = BackgroundSocialButtonColorLight,
    textColor = TextColorLight,
    secondaryButtonColor = SecondaryButtonColorLight,
    secondaryButtonTextColor = SecondaryButtonTextColorLight,
    switchColor =  SwitchInactiveBackgroundColorLight,
    iconColor = IconColorLight,
    successColor = SuccessColor,
    alertColor = AlertColor,
    warningColor = WarningColor,
    infoColor = InfoColor,
    disabledColor = DisabledColor,
    greyscale900Color = Greyscale900Color,
    greyscale800Color = Greyscale800Color,
    greyscale700Color = Greyscale700Color,
    greyscale600Color = Greyscale600Color,
    greyscale500Color = Greyscale500Color,
    greyscale400Color = Greyscale400Color,
    greyscale300Color = Greyscale300Color,
    greyscale200Color = Greyscale200Color,
    greyscale100Color = Greyscale100Color,
    greyscale50Color = Greyscale50Color,
    whiteColor = WhiteColor,
    blackColor = BlackColor,
    transparentColor = TransparentColor,
    spotColor = SpotColor,
    ambientColor = AmbientColor
)

private val DarkColorScheme = MyColorScheme(
    defaultColor = DefaultColor,
    alphaDefaultColor = AlphaDefaultColor,
    disabledDefaultColor = DisabledDefaultColor,
    primaryBackgroundColor = PrimaryBackgroundColorDark,
    secondaryBackgroundColor = SecondaryBackgroundColorDark,
    borderColor = BorderColorDark,
    dividerColor = DividerColorDark,
    topAppBarColor = TopAppBarColorDark,
    textFieldBackGroundColor = TextFieldBackGroundColorDark,
    backgroundSocialButtonColor = BackgroundSocialButtonColorDark,
    textColor = TextColorDark,
    secondaryButtonColor = SecondaryButtonColorDark,
    secondaryButtonTextColor = SecondaryButtonTextColorDark,
    switchColor =  SwitchInactiveBackgroundColorDark,
    iconColor = IconColorDark,
    successColor = SuccessColor,
    alertColor = AlertColor,
    warningColor = WarningColor,
    infoColor = InfoColor,
    disabledColor = DisabledColor,
    greyscale900Color = Greyscale900Color,
    greyscale800Color = Greyscale800Color,
    greyscale700Color = Greyscale700Color,
    greyscale600Color = Greyscale600Color,
    greyscale500Color = Greyscale500Color,
    greyscale400Color = Greyscale400Color,
    greyscale300Color = Greyscale300Color,
    greyscale200Color = Greyscale200Color,
    greyscale100Color = Greyscale100Color,
    greyscale50Color = Greyscale50Color,
    whiteColor = WhiteColor,
    blackColor = BlackColor,
    transparentColor = TransparentColor,
    spotColor = SpotColor,
    ambientColor = AmbientColor
)

private val LocalColorScheme = compositionLocalOf { LightColorScheme }

object MovieStreamingTheme {
    val colorScheme: MyColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current
}

@Composable
fun MovieStreamingTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme by remember(isDarkTheme) {
        mutableStateOf(if (isDarkTheme) DarkColorScheme else LightColorScheme)
    }

    CompositionLocalProvider(LocalColorScheme provides colorScheme) {
        MaterialTheme(content = content)
    }
}