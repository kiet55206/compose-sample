/*
 * Copyright © 2025. One Hungary. All rights reserved.
 */

package com.example.app.core.presentation.components.button.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.ui.theme.ComposeSampleAppTheme
import com.example.app.ui.theme.DS
import com.example.app.ui.theme.elementSizing

@Composable
fun FilledButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonColors: ButtonColors,
    isEnabled: Boolean = true,
    size: ButtonSize = ButtonSize.NORMAL,
    description: String? = null,
) {
    Button(
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
        onClick = onClick,
        shape = DS.shapes.large,
        enabled = isEnabled,
        colors = buttonColors,
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

@Preview
@Composable
fun NormalFilledButtonPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            FilledButton(
                text = "Normal filled button",
                buttonColors = ButtonDefaults.buttonColors(),
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
fun ThinFilledButtonPreview() {
    ComposeSampleAppTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            FilledButton(
                text = "Thin filled button",
                buttonColors = ButtonDefaults.buttonColors(),
                onClick = {},
                size = ButtonSize.THIN,
            )
        }
    }
}
