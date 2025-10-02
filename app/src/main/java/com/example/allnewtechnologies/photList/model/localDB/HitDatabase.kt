package com.example.allnewtechnologies.photList.model.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.allnewtechnologies.photList.model.Hit

@Database(entities = [Hit::class], version = 1)
abstract class HitDatabase: RoomDatabase() {
    abstract fun hitDao(): HitDao
}