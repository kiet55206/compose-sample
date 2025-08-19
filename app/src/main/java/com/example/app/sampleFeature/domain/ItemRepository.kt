package com.example.app.sampleFeature.domain

import com.example.app.core.domain.DataError
import com.example.app.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    suspend fun fetchItemList(): Result<List<Item>, DataError.Remote>

    fun observeItemList(): Flow<List<Item>>

    suspend fun toggleItemFavoriteStatus(id: String): Item?

    suspend fun getItemById(id: String): Item?

    suspend fun fetchItemDetail(name: String): Result<Item, DataError.Remote>

}
