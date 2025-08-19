package com.example.app.sampleFeature.presentation.detail

import com.example.app.core.presentation.UiText

sealed interface ItemDetailEvents {

    data class Error(val errorMessage: UiText): ItemDetailEvents

}
