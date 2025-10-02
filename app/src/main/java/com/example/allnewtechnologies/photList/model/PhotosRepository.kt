package com.example.allnewtechnologies.photList.model

import com.example.allnewtechnologies.photList.model.localDB.LocalDataSourceInt
import retrofit2.Response
import javax.inject.Inject


class PhotosRepository @Inject constructor(private val apiService: PhotosApi,
    private val localDataSource: LocalDataSourceInt
):
    PhotosRepositoryInterface {
    override suspend fun getPhotosList(page: Int, perPage: Int): Response<PhotoResponse> {
        val photos = apiService.getPhotosList(
            PhotosApi.API_KEY, "yellow+flowers", "photo", page, perPage
        )
//        localDataSource.saveData(photos.body()?.hits ?: emptyList())
        return photos
    }
}