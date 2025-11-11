package com.example.allnewtechnologies.photList.model.localDB

import com.example.allnewtechnologies.photList.model.responses.Hit
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val itemDao: HitDao
): LocalDataSourceInt {
    override suspend fun getLocalData() = itemDao.getAll()

    override suspend fun saveData(items: List<Hit>) = itemDao.insertAll(items)
}