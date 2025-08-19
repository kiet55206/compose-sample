package com.example.app.sampleFeature.data.mappers

import com.example.app.sampleFeature.data.database.entity.ItemEntity
import com.example.app.sampleFeature.data.dto.ItemDto
import com.example.app.sampleFeature.domain.Item

fun ItemDto.toEntity(existing: ItemEntity?): ItemEntity {
    return ItemEntity(
        id = id,
        name = name,
        height = height ?: existing?.height,
        weight = weight ?: existing?.weight,
        isFavorite = existing?.isFavorite == true,
    )
}

fun ItemEntity.toDomain(): Item {
    return Item(
        id = id,
        name = name,
        height = height,
        weight = weight,
        isFavorite = isFavorite,
    )
}
