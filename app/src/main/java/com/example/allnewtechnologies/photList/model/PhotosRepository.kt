package com.example.allnewtechnologies.photList.model

import com.example.allnewtechnologies.photList.model.localDB.LocalDataSourceInt
import retrofit2.Response
import javax.inject.Inject


class PhotosRepository @Inject constructor(
    private val apiService: PhotosApi,
    private val localDataSource: LocalDataSourceInt
) : PhotosRepositoryInterface {
    override suspend fun getPhotosList(
        page: Int,
        perPage: Int,
        isPagination: Boolean
    ): Response<PhotoResponse> {
        var photos: Response<PhotoResponse>
        val localPhotos = localDataSource.getLocalData()
        if (isPagination || (page == 1 && localPhotos.isEmpty())) {
            photos = apiService.getPhotosList(
                PhotosApi.API_KEY, "yellow+flowers", "photo", page, perPage
            )
            localDataSource.saveData(photos.body()?.hits ?: emptyList())
        } else {

            photos = Response.success(PhotoResponse(0, localPhotos.size, localPhotos.toMutableList()))
        }
        return photos
    }
}