package com.example.app.sampleFeature.presentation.detail

import com.example.app.sampleFeature.domain.Item

sealed interface ItemDetailAction {

    data object OnBackClicked: ItemDetailAction

    data class OnToggleCatch(val item: Item) : ItemDetailAction

}
