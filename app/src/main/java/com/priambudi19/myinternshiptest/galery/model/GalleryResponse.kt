package com.priambudi19.myinternshiptest.galery.model


import com.google.gson.annotations.SerializedName

data class GalleryResponse(
    @SerializedName("data")
    var data: List<Gallery>,
    @SerializedName("message")
    var message: String,
    @SerializedName("status_code")
    var statusCode: Int
)