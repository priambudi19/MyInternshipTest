package com.priambudi19.myinternshiptest.profile.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile(
    @SerializedName("avatar")
    var avatar: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("fullname")
    var fullname: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("username")
    var username: String
): Parcelable