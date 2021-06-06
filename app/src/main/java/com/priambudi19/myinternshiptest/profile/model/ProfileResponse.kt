package com.priambudi19.myinternshiptest.profile.model


import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("data")
    var `data`: Profile,
    @SerializedName("message")
    var message: String,
    @SerializedName("status_code")
    var statusCode: Int
)