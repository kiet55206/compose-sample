package com.example.app.sampleFeature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.app.R
import com.example.app.core.presentation.components.button.PrimaryButton
import com.example.app.core.presentation.components.button.TertiaryButton
import com.example.app.core.presentation.components.button.base.ButtonSize
import com.example.app.ui.theme.ComposeSampleAppTheme
import com.example.app.ui.theme.DS

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.NORMAL,
) {
    if (isFavorite) {
        TertiaryButton(
            modifier = modifier,
            text = stringResource(R.string.remove),
            onClick = onToggle,
            size = size,
        )
    } else {
        PrimaryButton(
            modifier = modifier,
            text = stringResource(R.string.add),
            onClick = onToggle,
            size = size,
        )

    }
}

class FavoriteButtonPreviewParameterProvider : PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(false, true)
}

@Composable
@Preview
private fun FavoriteButtonPreview(
    @PreviewParameter(FavoriteButtonPreviewParameterProvider::class) isFavorite: Boolean,
) {
    ComposeSampleAppTheme {
        Box(
            modifier = Modifier.background(color = DS.colorScheme.background)
        ) {
            FavoriteButton(
                isFavorite = isFavorite,
                onToggle = {},
            )
        }
    }
}
