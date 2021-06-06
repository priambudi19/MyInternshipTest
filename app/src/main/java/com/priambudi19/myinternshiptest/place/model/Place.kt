package com.priambudi19.myinternshiptest.place.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("content")
    @Expose
    var content: List<Content>,
    @SerializedName("header")
    @Expose
    var header: Header
)