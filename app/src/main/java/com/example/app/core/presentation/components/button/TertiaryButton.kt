/*
 * Copyright © 2025. One Hungary. All rights reserved.
 */

package com.example.app.core.presentation.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.core.presentation.components.button.base.ButtonSize
import com.example.app.core.presentation.components.button.base.ButtonType
import com.example.app.ui.theme.ComposeSampleAppTheme
import com.example.app.ui.theme.DS
import com.example.app.ui.theme.DSColors
import com.example.app.ui.theme.customColor
import com.example.app.ui.theme.elementSizing

@Composable
fun TertiaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    size: ButtonSize = ButtonSize.NORMAL,
    type: ButtonType = ButtonType.ON_LIGHT_BACKGROUND,
    description: String? = null,
) {
    val (buttonColors, borderColor) = when (type) {
        ButtonType.ON_LIGHT_BACKGROUND -> {
            Pair(
                ButtonDefaults.outlinedButtonColors(
                    contentColor = DS.colorScheme.tertiaryButtonOnLightContent,
                    disabledContainerColor = DS.colorScheme.tertiaryButtonOnLightContentDisabled,
                ),
                if (isEnabled) DS.colorScheme.tertiaryButtonOnLightStroke else DS.colorScheme.tertiaryButtonOnLightStrokeDisabled
            )
        }

        ButtonType.ON_DARK_BACKGROUND -> {
            Pair(
                ButtonDefaults.outlinedButtonColors(
                    contentColor = DS.colorScheme.tertiaryButtonOnDarkContent,
                    disabledContainerColor = DS.colorScheme.tertiaryButtonOnDarkContentDisabled,
                ),
                if (isEnabled) DS.colorScheme.tertiaryButtonOnDarkStroke else DS.colorScheme.tertiaryButtonOnDarkStrokeDisabled
            )
        }
    }
    OutlinedButton(
        modifier = modifier
            .semantics { contentDescription = description ?: text }
            .fillMaxWidth()
            .height(
                when (size) {
                    ButtonSize.NORMAL -> DS.elementSizing.buttonHeightBig
                    ButtonSize.THIN -> DS.elementSizing.buttonHeightSmall
                }
            ),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp),
        shape = DS.shapes.large,
        enabled = isEnabled,
        onClick = onClick,
        colors = buttonColors,
        border = BorderStroke(width = DS.elementSizing.buttonStroke, color = borderColor)
    ) {
        Text(
            text = text,
            style = when (size) {
                ButtonSize.NORMAL -> DS.typography.labelLarge
                ButtonSize.THIN -> DS.typography.labelSmall
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

val ColorScheme.tertiaryButtonOnLightStroke: Color
    @Composable get() = customColor(
        light = DSColors.OverlayBlack50,
        dark = DSColors.OverlayBlack50,
    )

val ColorScheme.tertiaryButtonOnLightStrokeDisabled: Color
    @Composable get() = customColor(
        light = DSColors.MidGray,
        dark = DSColors.MidGray,
    )

val ColorScheme.tertiaryButtonOnLightContent: Color
    @Composable get() = customColor(
        light = DSColors.Black87,
        dark = DSColors.Black87,
    )

val ColorScheme.tertiaryButtonOnLightContentDisabled: Color
    @Composable get() = customColor(
        light = DSColors.OneWhite,
        dark = DSColors.OneWhite,
    )

val ColorScheme.tertiaryButtonOnDarkStroke: Color
    @Composable get() = customColor(
        light = DSColors.OneWhite,
        dark = DSColors.OneWhite,
    )

val ColorScheme.tertiaryButtonOnDarkStrokeDisabled: Color
    @Composable get() = customColor(
        light = DSColors.MidGray,
        dark = DSColors.MidGray,
    )

val ColorScheme.tertiaryButtonOnDarkContent: Color
    @Composable get() = customColor(
        light = DSColors.OneWhite,
        dark = DSColors.OneWhite,
    )

val ColorScheme.tertiaryButtonOnDarkContentDisabled: Color
    @Composable get() = customColor(
        light = DSColors.OneWhite,
        dark = DSColors.OneWhite,
    )

@Preview
@Composable
fun TertiaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            TertiaryButton(
                text = "Tertiary button on light",
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
fun DisabledTertiaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            TertiaryButton(
                text = "Disabled tertiary button on light",
                onClick = {},
                isEnabled = false,
            )
        }
    }
}

@Preview
@Composable
fun ThinTertiaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            TertiaryButton(
                text = "Thin tertiary button on light",
                onClick = {},
                size = ButtonSize.THIN,
            )
        }
    }
}

@Preview
@Composable
fun DisabledThinTertiaryButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            TertiaryButton(
                text = "Disabled thin tertiary button on light",
                onClick = {},
                isEnabled = false,
                size = ButtonSize.THIN,
            )
        }
    }
}

@Preview
@Composable
fun TertiaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            TertiaryButton(
                text = "Tertiary button on dark",
                onClick = {},
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun DisabledTertiaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            TertiaryButton(
                text = "Disabled tertiary button on dark",
                onClick = {},
                isEnabled = false,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun ThinTertiaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            TertiaryButton(
                text = "Thin tertiary button on dark",
                onClick = {},
                size = ButtonSize.THIN,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun DisabledThinTertiaryButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            TertiaryButton(
                text = "Disabled thin tertiary button on dark",
                onClick = {},
                isEnabled = false,
                size = ButtonSize.THIN,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}
