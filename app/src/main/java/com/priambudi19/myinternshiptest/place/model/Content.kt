package com.priambudi19.myinternshiptest.place.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Content(
    @SerializedName("content")
    @Expose
    var content: String,
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("image")
    @Expose
    var image: String,
    @SerializedName("media")
    @Expose
    var media: List<String>,
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("type")
    @Expose
    var type: String,
):Parcelable