package com.example.app.sampleFeature.presentation.list

import com.example.app.sampleFeature.domain.Item

data class ItemListUIState(
    val itemListState: ItemListState = ItemListState.ListLoaded(),
    val isLoading: Boolean = false,
)

sealed class ItemListState {
    data class ListLoaded(val listItems: List<Item> = emptyList()): ItemListState()
    data object ListEmpty: ItemListState()
}
