package com.example.app.core.presentation.components.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.app.R
import com.example.app.core.presentation.UiText
import com.example.app.core.presentation.components.button.PrimaryButton
import com.example.app.ui.theme.DS

data class ErrorAlertDialogModel(
    val text: UiText,
    val onPositiveAction: () -> Unit,
    val onDismissAction: () -> Unit,
)

@Composable
fun ErrorAlertDialog(dialogModel: ErrorAlertDialogModel?) {
    if (dialogModel != null) {
        AlertDialog(
            shape = DS.shapes.medium,
            title = {
                Text(text = stringResource(R.string.error))
            },
            text = {
                Text(text = dialogModel.text.asString())
            },
            confirmButton = {
                PrimaryButton(
                    text = stringResource(R.string.ok),
                    onClick = dialogModel.onPositiveAction
                )
            },
            onDismissRequest = dialogModel.onDismissAction
        )
    }
}
