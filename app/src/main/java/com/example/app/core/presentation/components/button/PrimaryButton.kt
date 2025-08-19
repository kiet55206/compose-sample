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
fun PrimaryButton(
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
                containerColor = if (size == ButtonSize.THIN ) { DSColors.OneBlack } else { DS.colorScheme.primaryButtonOnLightBackground },
                disabledContainerColor = DS.colorScheme.primaryButtonOnLightBackgroundDisabled,
                contentColor = if (size == ButtonSize.THIN ) { DSColors.OneWhite } else { DS.colorScheme.primaryButtonOnLightContent },
            )
        }
        ButtonType.ON_DARK_BACKGROUND -> {
            ButtonDefaults.buttonColors(
                containerColor = DS.colorScheme.primaryButtonOnDarkBackground,
                disabledContainerColor = DS.colorScheme.primaryButtonOnDarkBackgroundDisabled,
                contentColor = DS.colorScheme.primaryButtonOnDarkContent,
                disabledContentColor = DS.colorScheme.primaryButtonOnDarkContentDisabled,
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

val ColorScheme.primaryButtonOnLightBackground: Color
    @Composable get() = customColor(
        light = DSColors.OneTeal,
        dark = DSColors.OneTeal,
    )

val ColorScheme.primaryButtonOnLightBackgroundDisabled: Color
    @Composable get() = customColor(
        light = DSColors.MidGray,
        dark = DSColors.MidGray,
    )

val ColorScheme.primaryButtonOnLightContent: Color
    @Composable get() = customColor(
        light = DSColors.OneWhite,
        dark = DSColors.OneWhite,
    )


val ColorScheme.primaryButtonOnDarkBackground: Color
    @Composable get() = customColor(
        light = DSColors.OneWhite,
        dark = DSColors.OneWhite,
    )

val ColorScheme.primaryButtonOnDarkBackgroundDisabled: Color
    @Composable get() = customColor(
        light = DSColors.MidGray,
        dark = DSColors.MidGray,
    )

val ColorScheme.primaryButtonOnDarkContent: Color
    @Composable get() = customColor(
        light = DSColors.Black87,
        dark = DSColors.Black87,
    )

val ColorScheme.primaryButtonOnDarkContentDisabled: Color
    @Composable get() = customColor(
        light = DSColors.OneWhite,
        dark = DSColors.OneWhite,
    )

@Preview
@Composable
fun PrimaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            PrimaryButton(
                text = "Primary button on light",
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
fun DisabledPrimaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            PrimaryButton(
                text = "Disabled primary button on light",
                onClick = {},
                isEnabled = false,
            )
        }
    }
}

@Preview
@Composable
fun ThinPrimaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            PrimaryButton(
                text = "Thin primary button on light",
                onClick = {},
                size = ButtonSize.THIN,
            )
        }
    }
}

@Preview
@Composable
fun DisabledThinPrimaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            PrimaryButton(
                text = "Disabled thin primary button on light",
                onClick = {},
                isEnabled = false,
                size = ButtonSize.THIN,
            )
        }
    }
}

@Preview
@Composable
fun PrimaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            PrimaryButton(
                text = "Primary button on dark",
                onClick = {},
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun DisabledPrimaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            PrimaryButton(
                text = "Disabled primary button on dark",
                onClick = {},
                isEnabled = false,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun ThinPrimaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            PrimaryButton(
                text = "Thin primary button on dark",
                onClick = {},
                size = ButtonSize.THIN,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun DisabledThinPrimaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            PrimaryButton(
                text = "Disabled thin primary button on dark",
                onClick = {},
                isEnabled = false,
                size = ButtonSize.THIN,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}
