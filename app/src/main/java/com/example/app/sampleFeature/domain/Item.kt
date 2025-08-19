package com.example.app.sampleFeature.domain

data class Item(
    val id: String,
    val name: String,
    val isFavorite: Boolean,
    val height: Int? = null,
    val weight: Int? = null,
)
