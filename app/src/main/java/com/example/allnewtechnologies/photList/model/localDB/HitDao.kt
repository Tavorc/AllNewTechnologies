package com.example.allnewtechnologies.photList.model.localDB

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.allnewtechnologies.photList.model.responses.Hit

@Dao
interface HitDao {

    @Upsert
    suspend fun insertAll(hits: List<Hit>)

    @Query("SELECT * FROM Hit")
    fun getAll(): List<Hit>
}