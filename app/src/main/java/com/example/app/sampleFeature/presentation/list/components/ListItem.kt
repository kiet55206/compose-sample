package com.example.app.sampleFeature.presentation.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.app.core.presentation.components.button.base.ButtonSize
import com.example.app.sampleFeature.domain.Item
import com.example.app.sampleFeature.presentation.components.FavoriteButton
import com.example.app.sampleFeature.presentation.list.ItemListAction
import com.example.app.ui.theme.ComposeSampleAppTheme
import com.example.app.ui.theme.DS

@Composable
fun ListItem(
    item: Item,
    onAction: (ItemListAction) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onAction(ItemListAction.OnItemSelected(item)) }
            .padding(16.dp)
    ) {
        Text(text = item.name, color = Color.Black)
        Spacer(modifier = Modifier.weight(1f))
        FavoriteButton(
            modifier = Modifier.width(100.dp),
            isFavorite = item.isFavorite,
            size = ButtonSize.THIN,
            onToggle = {
                onAction(ItemListAction.OnToggleFavorite(item))
            },
        )
    }
}

class ListItemPreviewParameterProvider : PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(false, true)
}

@Composable
@Preview
private fun ListItemPreview(
    @PreviewParameter(ListItemPreviewParameterProvider::class) isFavorite: Boolean,
) {
    ComposeSampleAppTheme {
        Box(
            modifier = Modifier.background(color = DS.colorScheme.background)
        ) {
            ListItem(
                item = Item(id = "1", name = "Item 1", isFavorite = isFavorite)
            ) { }
        }
    }
}
