package com.example.app.sampleFeature.data.network

import com.example.app.core.domain.DataError
import com.example.app.core.domain.Result
import com.example.app.sampleFeature.data.dto.ItemDto
import com.example.app.sampleFeature.data.dto.ItemListDto
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockItemApi @Inject constructor() : ItemApi {

    override suspend fun fetchItemList(): Result<ItemListDto, DataError.Remote> {
        delay(1_00L)
        return Result.Success(
            ItemListDto(
                results = items
            )
        )
    }

    override suspend fun fetchItemDetail(id: String): Result<ItemDto, DataError.Remote> {
        delay(500L)
        return items.firstOrNull { it.id == id }?.let {
            Result.Success(it.copy(height = 10, weight = 200))
        } ?: Result.Error(DataError.Remote.Unknown)
    }

    private val items by lazy {
        (0..20).map {
            ItemDto(
                id = it.toString(),
                name = "Item $it",
            )
        }
    }

}
