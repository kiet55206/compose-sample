package com.example.app.core.presentation.components.button.dynamicButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.app.core.presentation.components.button.LinkButton
import com.example.app.core.presentation.components.button.PrimaryButton
import com.example.app.core.presentation.components.button.SecondaryButton
import com.example.app.core.presentation.components.button.TertiaryButton
import com.example.app.core.presentation.components.button.base.ButtonTheme

@Composable
fun DynamicButton(
    modifier: Modifier = Modifier,
    action: ComposeButtonGeneratorAction,
    onClick: () -> Unit,
) {
    when (action.theme) {
        ButtonTheme.PRIMARY -> PrimaryButton(
            modifier = modifier,
            text = action.title,
            onClick = onClick,
            size = action.size,
            type = action.type,
            isEnabled = action.isActive == true,
            description = action.contentDescription,
        )

        ButtonTheme.SECONDARY -> SecondaryButton(
            modifier = modifier,
            text = action.title,
            onClick = onClick,
            size = action.size,
            type = action.type,
            isEnabled = action.isActive == true,
            description = action.contentDescription,
        )

        ButtonTheme.TERTIARY -> TertiaryButton(
            modifier = modifier,
            text = action.title,
            onClick = onClick,
            size = action.size,
            type = action.type,
            isEnabled = action.isActive == true,
            description = action.contentDescription,
        )

        ButtonTheme.LINK -> LinkButton(
            modifier = modifier,
            text = action.title,
            onClick = onClick,
            size = action.size,
            type = action.type,
            isEnabled = action.isActive == true,
            description = action.contentDescription,
        )
    }
}
