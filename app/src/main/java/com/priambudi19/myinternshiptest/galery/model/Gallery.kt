package com.priambudi19.myinternshiptest.galery.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gallery(
    @SerializedName("caption")
    var caption: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("thumbnail")
    var thumbnail: String
): Parcelable