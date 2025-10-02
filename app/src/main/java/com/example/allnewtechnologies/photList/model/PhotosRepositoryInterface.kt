package com.example.allnewtechnologies.photList.model

import retrofit2.Response

interface PhotosRepositoryInterface {
    suspend fun getPhotosList(page: Int, perPage: Int): Response<PhotoResponse>
}