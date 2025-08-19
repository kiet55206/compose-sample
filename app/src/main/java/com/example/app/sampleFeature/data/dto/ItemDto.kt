package com.example.app.sampleFeature.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemDto(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("height")
    val height: Int? = null,
    @SerialName("weight")
    val weight: Int? = null,
)
