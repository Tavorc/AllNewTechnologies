package com.example.allnewtechnologies.photList.model.responses

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Hit(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("pageURL")
    @Expose
    val pageURL: String,

    @SerializedName("tags")
    @Expose
    val tags: String,

    @SerializedName("type")
    @Expose
    val type: String,


    @SerializedName("previewURL")
    @Expose
    val previewURL: String,

    @SerializedName("previewWidth")
    @Expose
    val previewWidth: Int,

    @SerializedName("previewHeight")
    @Expose
    val previewHeight: Int,

    @SerializedName("webformatURL")
    @Expose
    val webformatURL: String,

    @SerializedName("webformatWidth")
    @Expose
    val webformatWidth: Int,

    @SerializedName("webformatHeight")
    @Expose
    val webformatHeight: Int,

    @SerializedName("largeImageURL")
    @Expose
    val largeImageURL: String,

    @SerializedName("imageWidth")
    @Expose
    val imageWidth: Int,

    @SerializedName("imageHeight")
    @Expose
    val imageHeight: Int,

    @SerializedName("imageSize")
    @Expose
    val imageSize: Int,

    @SerializedName("views")
    @Expose
    val views: Int,

    @SerializedName("downloads")
    @Expose
    val downloads: Int,

    @SerializedName("collections")
    @Expose
    val collections: Int,

    @SerializedName("likes")
    @Expose
    val likes: Int,

    @SerializedName("comments")
    @Expose
    val comments: Int,

    @SerializedName("user_id")
    @Expose
    val user_id: Int,

    @SerializedName("user")
    @Expose
    val user: String,

    @SerializedName("userImageURL")
    @Expose
    val userImageURL: String,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(pageURL)
        parcel.writeString(tags)
        parcel.writeString(type)
        parcel.writeString(previewURL)
        parcel.writeInt(previewWidth)
        parcel.writeInt(previewHeight)
        parcel.writeString(webformatURL)
        parcel.writeInt(webformatWidth)
        parcel.writeInt(webformatHeight)
        parcel.writeString(largeImageURL)
        parcel.writeInt(imageWidth)
        parcel.writeInt(imageHeight)
        parcel.writeInt(imageSize)
        parcel.writeInt(views)
        parcel.writeInt(downloads)
        parcel.writeInt(collections)
        parcel.writeInt(likes)
        parcel.writeInt(comments)
        parcel.writeInt(user_id)
        parcel.writeString(user)
        parcel.writeString(userImageURL)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hit> {
        override fun createFromParcel(parcel: Parcel): Hit {
            return Hit(parcel)
        }

        override fun newArray(size: Int): Array<Hit?> {
            return arrayOfNulls(size)
        }
    }
}

