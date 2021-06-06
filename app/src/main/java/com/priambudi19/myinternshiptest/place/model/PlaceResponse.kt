package com.priambudi19.myinternshiptest.place.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PlaceResponse(
    @SerializedName("data")
    @Expose
    var data: Place,
    @SerializedName("message")
    @Expose
    var message: String,
    @SerializedName("status_code")
    @Expose
    var statusCode: Int
)