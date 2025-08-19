package com.example.app.sampleFeature.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.app.sampleFeature.data.database.dao.ItemDao
import com.example.app.sampleFeature.data.database.entity.ItemEntity

@Database(
    entities = [
        ItemEntity::class,
    ],
    version = 1
)
abstract class ItemDatabase : RoomDatabase() {
    abstract val itemDao: ItemDao
}
