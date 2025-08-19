/*
 * Copyright © 2025. One Hungary. All rights reserved.
 */

package com.example.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ElementSizing(
    val radiusSmall: Dp = 8.dp,
    val radiusMedium: Dp = 16.dp,
    val radiusLarge: Dp = 32.dp,

    val buttonHeightBig: Dp = 44.dp,
    val buttonHeightSmall: Dp = 30.dp,
    val buttonStroke: Dp = 1.dp,
)

val LocalElementSizing = compositionLocalOf { ElementSizing() }

val MaterialTheme.elementSizing: ElementSizing
    @Composable
    @ReadOnlyComposable
    get() = LocalElementSizing.current
