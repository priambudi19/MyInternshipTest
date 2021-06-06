package com.priambudi19.myinternshiptest.network.rest

import com.priambudi19.myinternshiptest.place.model.PlaceResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestApiPlace {
    @GET("place.json")
    suspend fun getListPlace(): Response<PlaceResponse>
}