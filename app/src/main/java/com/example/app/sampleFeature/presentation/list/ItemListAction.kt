package com.example.app.sampleFeature.presentation.list

import com.example.app.sampleFeature.domain.Item

sealed interface ItemListAction {

    data object OnBackClicked : ItemListAction

    data class OnItemSelected(val item: Item) : ItemListAction

    data class OnToggleFavorite(val item: Item) : ItemListAction

}
