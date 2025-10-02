package com.example.allnewtechnologies.photList.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosApi {

    companion object {
        const val URL = "https://pixabay.com/"
        const val KEY = "key"
        const val API_KEY = "31446954-edf3420b6fa17ef837e12cfbf"
        const val PAGE = "page"
        const val PER_PAGE = "per_page"
        const val Q = "q"
        const val IMAGE_TYPE = "image_type"
    }

    @GET("api/")
    suspend fun getPhotosList(
        @Query(KEY) apiKey: String,
        @Query(Q) q: String,
        @Query(IMAGE_TYPE) imageType: String,
        @Query(PAGE) page: Int,
        @Query(PER_PAGE) perPage: Int
    ): Response<PhotoResponse>
}