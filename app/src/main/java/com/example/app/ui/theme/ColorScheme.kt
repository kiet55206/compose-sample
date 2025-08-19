/*
 * Copyright © 2025. One Hungary. All rights reserved.
 */

package com.example.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

internal val DarkColorScheme = darkColorScheme(
    primary = DSColors.OneTeal,
    onPrimary = DSColors.OneWhite,
    primaryContainer = DSColors.OneTealAccPass,
    secondary = DSColors.OneTealAccPass,
    onSecondary = DSColors.OneWhite,
    background = DSColors.OneWhite,
    onBackground = DSColors.OneBlack,
    surface = DSColors.OneWhite,
    onSurface = DSColors.OneBlack,
    error = DSColors.Error,
    onError = DSColors.LightLavender,
)

internal val LightColorScheme = lightColorScheme(
    primary = DSColors.OneTeal,
    onPrimary = DSColors.OneWhite,
    primaryContainer = DSColors.OneTealAccPass,
    secondary = DSColors.OneTealAccPass,
    onSecondary = DSColors.OneWhite,
    background = DSColors.OneWhite,
    onBackground = DSColors.OneBlack,
    surface = DSColors.OneWhite,
    onSurface = DSColors.OneBlack,
    error = DSColors.Error,
    onError = DSColors.LightLavender,
)

@Composable
fun customColor(light: Color, dark: Color): Color {
    return if(isSystemInDarkTheme()) dark else light
}
