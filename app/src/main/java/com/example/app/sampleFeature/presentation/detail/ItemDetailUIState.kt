package com.example.app.sampleFeature.presentation.detail

import com.example.app.sampleFeature.domain.Item

data class ItemDetailUIState(
    val itemDetailState: ItemDetailState = ItemDetailState.ItemDetailEmpty,
    val isLoading: Boolean = false,
)

sealed class ItemDetailState {
    data class ItemDetailLoaded(val item: Item): ItemDetailState()
    data object ItemDetailEmpty: ItemDetailState()
}
