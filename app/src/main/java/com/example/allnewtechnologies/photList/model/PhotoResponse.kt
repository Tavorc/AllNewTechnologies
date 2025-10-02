package com.example.allnewtechnologies.photList.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("total")
    @Expose
    val total: Int,

    @SerializedName("totalHits")
    @Expose
    val totalHits: Int,

    @SerializedName("hits")
    @Expose
    val hits: MutableList<Hit> = mutableListOf(),
)
