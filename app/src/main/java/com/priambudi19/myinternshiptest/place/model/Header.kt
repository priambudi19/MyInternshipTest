package com.priambudi19.myinternshiptest.place.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("subtitle")
    @Expose
    var subtitle: String,
    @SerializedName("title")
    @Expose
    var title: String
)