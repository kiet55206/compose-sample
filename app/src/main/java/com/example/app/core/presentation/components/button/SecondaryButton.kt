/*
 * Copyright © 2025. One Hungary. All rights reserved.
 */

package com.example.app.core.presentation.components.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.core.presentation.components.button.base.ButtonSize
import com.example.app.core.presentation.components.button.base.ButtonType
import com.example.app.core.presentation.components.button.base.FilledButton
import com.example.app.ui.theme.ComposeSampleAppTheme
import com.example.app.ui.theme.DS
import com.example.app.ui.theme.DSColors
import com.example.app.ui.theme.customColor

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    size: ButtonSize = ButtonSize.NORMAL,
    type: ButtonType = ButtonType.ON_LIGHT_BACKGROUND,
    description: String? = null,
) {
    val buttonColors = when (type) {
        ButtonType.ON_LIGHT_BACKGROUND -> {
            ButtonDefaults.buttonColors(
                containerColor = DS.colorScheme.secondaryButtonOnLightBackground,
                disabledContainerColor = DS.colorScheme.secondaryButtonOnLightBackgroundDisabled,
                contentColor = DS.colorScheme.secondaryButtonOnLightContent,
            )
        }

        ButtonType.ON_DARK_BACKGROUND -> {
            ButtonDefaults.buttonColors(
                containerColor = DS.colorScheme.secondaryButtonOnDarkBackground,
                disabledContainerColor = DS.colorScheme.secondaryButtonOnDarkBackgroundDisabled,
                contentColor = DS.colorScheme.secondaryButtonOnDarkContent,
                disabledContentColor = DS.colorScheme.secondaryButtonOnDarkContentDisabled,
            )
        }
    }
    FilledButton(
        modifier = modifier,
        text = text,
        onClick = onClick,
        buttonColors = buttonColors,
        isEnabled = isEnabled,
        size = size,
        description = description
    )
}

val ColorScheme.secondaryButtonOnLightBackground: Color
    @Composable get() = customColor(
        light = DSColors.Black60,
        dark = DSColors.Black60,
    )

val ColorScheme.secondaryButtonOnLightBackgroundDisabled: Color
    @Composable get() = customColor(
        light = DSColors.MidGray,
        dark = DSColors.MidGray,
    )

val ColorScheme.secondaryButtonOnLightContent: Color
    @Composable get() = customColor(
        light = DSColors.OneWhite,
        dark = DSColors.OneWhite,
    )


val ColorScheme.secondaryButtonOnDarkBackground: Color
    @Composable get() = customColor(
        light = DSColors.OverlayBlack50,
        dark = DSColors.OverlayBlack50,
    )

val ColorScheme.secondaryButtonOnDarkBackgroundDisabled: Color
    @Composable get() = customColor(
        light = DSColors.MidGray,
        dark = DSColors.MidGray,
    )

val ColorScheme.secondaryButtonOnDarkContent: Color
    @Composable get() = customColor(
        light = DSColors.Black87,
        dark = DSColors.Black87,
    )

val ColorScheme.secondaryButtonOnDarkContentDisabled: Color
    @Composable get() = customColor(
        light = DSColors.OneWhite,
        dark = DSColors.OneWhite,
    )

@Preview
@Composable
fun SecondaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            SecondaryButton(
                text = "Secondary button on light",
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
fun DisabledSecondaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            SecondaryButton(
                text = "Disabled secondary button on light",
                onClick = {},
                isEnabled = false,
            )
        }
    }
}

@Preview
@Composable
fun ThinSecondaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            SecondaryButton(
                text = "Thin secondary button on light",
                onClick = {},
                size = ButtonSize.THIN,
            )
        }
    }
}

@Preview
@Composable
fun DisabledThinSecondaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            SecondaryButton(
                text = "Disabled thin secondary button on light",
                onClick = {},
                isEnabled = false,
                size = ButtonSize.THIN,
            )
        }
    }
}

@Preview
@Composable
fun SecondaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            SecondaryButton(
                text = "Secondary button on dark",
                onClick = {},
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun DisabledSecondaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            SecondaryButton(
                text = "Disabled secondary button on dark",
                onClick = {},
                isEnabled = false,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun ThinSecondaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            SecondaryButton(
                text = "Thin secondary button on dark",
                onClick = {},
                size = ButtonSize.THIN,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun DisabledThinSecondaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            SecondaryButton(
                text = "Disabled thin secondary button on dark",
                onClick = {},
                isEnabled = false,
                size = ButtonSize.THIN,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}
