package com.example.app.sampleFeature.data.service

import com.example.app.core.domain.DataError
import com.example.app.core.domain.Result
import com.example.app.core.domain.map
import com.example.app.sampleFeature.data.database.dao.ItemDao
import com.example.app.sampleFeature.data.mappers.toDomain
import com.example.app.sampleFeature.data.mappers.toEntity
import com.example.app.sampleFeature.data.network.ItemApi
import com.example.app.sampleFeature.domain.Item
import com.example.app.sampleFeature.domain.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultItemRepository @Inject constructor(
    private val itemApi: ItemApi,
    private val itemDao: ItemDao,
) : ItemRepository {

    override suspend fun fetchItemList(): Result<List<Item>, DataError.Remote> {
        return itemApi.fetchItemList()
            .map { result ->
                val merged = result.results.map { dto ->
                    val local = itemDao.getById(dto.id)
                    dto.toEntity(local)
                }
                itemDao.upsertAll(merged)
                merged.map { it.toDomain() }
            }
    }

    override fun observeItemList(): Flow<List<Item>> {
        return itemDao.observeAll().map { it.map { it.toDomain() } }
    }

    override suspend fun toggleItemFavoriteStatus(id: String): Item? {
        itemDao.toggleIsFavorite(id)
        return itemDao.getById(id)?.toDomain()
    }

    override suspend fun getItemById(id: String): Item? {
        return itemDao.getById(id)?.toDomain()
    }

    override suspend fun fetchItemDetail(name: String): Result<Item, DataError.Remote> {
        return itemApi.fetchItemDetail(name)
            .map { result ->
                val local = itemDao.getById(result.id)
                val new = result.toEntity(local)
                itemDao.upsert(new)
                new.toDomain()
            }
    }

}
