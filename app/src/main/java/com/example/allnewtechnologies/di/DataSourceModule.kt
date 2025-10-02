package com.example.allnewtechnologies.di

import android.content.Context
import androidx.room.Room
import com.example.allnewtechnologies.photList.model.localDB.HitDao
import com.example.allnewtechnologies.photList.model.localDB.HitDatabase
import com.example.allnewtechnologies.photList.model.localDB.LocalDataSourceInt
import com.example.allnewtechnologies.photList.model.localDB.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideLocalDataSource(hitDao: HitDao): LocalDataSourceInt {
        return LocalDataSource(hitDao)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): HitDatabase {
        return Room.databaseBuilder(
            context,
            HitDatabase::class.java,
            "photo_db"
        ).build()
    }

    @Provides
    fun provideHitDao(appDatabase: HitDatabase): HitDao {
        // Hilt will get appDatabase from the provider above and use it here.
        return appDatabase.hitDao() // <-- Ensure your AppDatabase class has a `hitDao()` abstract function.
    }
}