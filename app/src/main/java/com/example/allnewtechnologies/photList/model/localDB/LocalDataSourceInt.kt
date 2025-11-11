package com.example.allnewtechnologies.photList.model.localDB

import com.example.allnewtechnologies.photList.model.responses.Hit

interface LocalDataSourceInt {
    suspend fun getLocalData(): List<Hit>
    suspend fun saveData(items: List<Hit>)
}