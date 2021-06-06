package com.priambudi19.myinternshiptest.network.rest

import com.priambudi19.myinternshiptest.profile.model.ProfileResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestApiProfile {
    @GET("user.json")
    suspend fun getProfile() : Response<ProfileResponse>
}