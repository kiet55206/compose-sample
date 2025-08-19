package com.example.app.sampleFeature.data.network

import com.example.app.core.domain.DataError
import com.example.app.core.domain.Result
import com.example.app.sampleFeature.data.dto.ItemDto
import com.example.app.sampleFeature.data.dto.ItemListDto

interface ItemApi {

    suspend fun fetchItemList(): Result<ItemListDto, DataError.Remote>

    suspend fun fetchItemDetail(id: String): Result<ItemDto, DataError.Remote>

}
