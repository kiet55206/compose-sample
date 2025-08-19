/*
 * Copyright © 2025. One Hungary. All rights reserved.
 */

package com.example.app.core.presentation.components.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
fun LinkButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    size: ButtonSize = ButtonSize.NORMAL,
    type: ButtonType = ButtonType.ON_LIGHT_BACKGROUND,
    description: String? = null,
) {
    val (contentColor, disabledContentColor) = when (type) {
        ButtonType.ON_LIGHT_BACKGROUND -> Pair(
            DS.colorScheme.linkButtonOnLightContent,
            DS.colorScheme.linkButtonOnLightContentDisabled
        )

        ButtonType.ON_DARK_BACKGROUND -> Pair(
            DS.colorScheme.linkButtonOnDarkContent,
            DS.colorScheme.linkButtonOnDarkContentDisabled
        )
    }
    TextButton(
        modifier = modifier
            .semantics { contentDescription = description ?: text }
            .fillMaxWidth()
            .height(
                when (size) {
                    ButtonSize.NORMAL -> DS.elementSizing.buttonHeightBig
                    ButtonSize.THIN -> DS.elementSizing.buttonHeightSmall
                }
            ),
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(
            contentColor = contentColor,
            disabledContentColor = disabledContentColor,
            containerColor = Color.Transparent
        ),
        enabled = isEnabled,
        contentPadding = PaddingValues(0.dp),
        shape = DS.shapes.large,
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

val ColorScheme.linkButtonOnLightContent: Color
    @Composable get() = customColor(
        light = DSColors.OneTeal,
        dark = DSColors.OneTeal,
    )

val ColorScheme.linkButtonOnLightContentDisabled: Color
    @Composable get() = customColor(
        light = DSColors.OverlayBlack50,
        dark = DSColors.OverlayBlack50,
    )

val ColorScheme.linkButtonOnDarkContent: Color
    @Composable get() = customColor(
        light = DSColors.OneWhite,
        dark = DSColors.OneWhite,
    )

val ColorScheme.linkButtonOnDarkContentDisabled: Color
    @Composable get() = customColor(
        light = DSColors.MidGray,
        dark = DSColors.MidGray,
    )

@Preview
@Composable
fun LinkButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            LinkButton(
                text = "Link button on light",
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
fun DisabledLinkButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            LinkButton(
                text = "Disabled link button on light",
                onClick = {},
                isEnabled = false,
            )
        }
    }
}

@Preview
@Composable
fun ThinLinkButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            LinkButton(
                text = "Thin link button on light",
                onClick = {},
                size = ButtonSize.THIN,
            )
        }
    }
}

@Preview
@Composable
fun DisabledThinLinkButtonOnLightPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            LinkButton(
                text = "Disabled thin link button on light",
                onClick = {},
                isEnabled = false,
                size = ButtonSize.THIN,
            )
        }
    }
}

@Preview
@Composable
fun LinkButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            LinkButton(
                text = "Link button on dark",
                onClick = {},
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun DisabledLinkButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            LinkButton(
                text = "Disabled link button on dark",
                onClick = {},
                isEnabled = false,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun ThinLinkButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            LinkButton(
                text = "Thin link button on dark",
                onClick = {},
                size = ButtonSize.THIN,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}

@Preview
@Composable
fun DisabledThinLinkButtonOnDarkPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            LinkButton(
                text = "Disabled thin link button on dark",
                onClick = {},
                isEnabled = false,
                size = ButtonSize.THIN,
                type = ButtonType.ON_DARK_BACKGROUND,
            )
        }
    }
}
