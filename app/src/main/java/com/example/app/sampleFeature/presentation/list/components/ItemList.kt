package com.example.app.sampleFeature.presentation.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.sampleFeature.domain.Item
import com.example.app.sampleFeature.presentation.list.ItemListAction
import com.example.app.sampleFeature.presentation.list.ItemListState
import com.example.app.ui.theme.ComposeSampleAppTheme
import com.example.app.ui.theme.DS

@Composable
fun ItemList(
    itemListState: ItemListState.ListLoaded,
    onAction: (ItemListAction) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = itemListState.listItems
        ) { item ->
            ListItem(item, onAction)
        }
    }
}

@Composable
@Preview
private fun ItemListPreview() {
    ComposeSampleAppTheme {
        val listItems =
            (1..20).map { Item(id = it.toString(), name = "Item $it", isFavorite = false) }
        val itemListState = ItemListState.ListLoaded(listItems)
        Box(
            modifier = Modifier.background(color = DS.colorScheme.background)
        ) {
            ItemList(
                itemListState = itemListState
            ) { }
        }
    }
}
