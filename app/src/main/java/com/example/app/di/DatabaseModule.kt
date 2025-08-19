package com.example.app.di

import android.content.Context
import androidx.room.Room
import com.example.app.sampleFeature.data.database.ItemDatabase
import com.example.app.sampleFeature.data.database.dao.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideItemDatabase(@ApplicationContext context: Context): ItemDatabase {
        return Room.databaseBuilder(
            context,
            ItemDatabase::class.java,
            "item_database"
        ).build()
    }

    @Provides
    fun provideItemDao(database: ItemDatabase): ItemDao {
        return database.itemDao
    }
}
