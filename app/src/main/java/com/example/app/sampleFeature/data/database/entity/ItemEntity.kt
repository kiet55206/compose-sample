package com.example.app.sampleFeature.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val height: Int? = null,
    val weight: Int? = null,
    val isFavorite: Boolean,
)
