package com.example.allnewtechnologies.photList.model.localDB

import com.example.allnewtechnologies.photList.model.Hit

interface LocalDataSourceInt {
    suspend fun getLocalData(): List<Hit>
    suspend fun saveData(items: List<Hit>)
}