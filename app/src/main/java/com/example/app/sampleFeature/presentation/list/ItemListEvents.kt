package com.example.app.sampleFeature.presentation.list

import com.example.app.core.presentation.UiText

sealed interface ItemListEvents {

    data class Error(val errorMessage: UiText): ItemListEvents

}
