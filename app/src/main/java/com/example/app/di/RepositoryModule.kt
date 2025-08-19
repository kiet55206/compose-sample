package com.example.app.di

import com.example.app.sampleFeature.data.service.DefaultItemRepository
import com.example.app.sampleFeature.domain.ItemRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindItemRepository(
        defaultItemService: DefaultItemRepository
    ): ItemRepository
}
