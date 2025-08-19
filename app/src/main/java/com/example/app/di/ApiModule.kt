package com.example.app.di

import com.example.app.sampleFeature.data.network.ItemApi
import com.example.app.sampleFeature.data.network.MockItemApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiModule {

    @Binds
    abstract fun bindItemApi(
        mockItemApi: MockItemApi,
    ): ItemApi
}
