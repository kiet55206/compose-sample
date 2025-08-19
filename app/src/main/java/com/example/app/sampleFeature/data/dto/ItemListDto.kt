package com.example.app.sampleFeature.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemListDto(
    @SerialName("results")
    val results: List<ItemDto> = emptyList(),
)
