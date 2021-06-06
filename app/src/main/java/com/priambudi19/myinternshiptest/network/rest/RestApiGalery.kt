package com.priambudi19.myinternshiptest.network.rest

import com.priambudi19.myinternshiptest.galery.model.GalleryResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestApiGalery {
    @GET("gallery.json")
    suspend fun getListGallery(): Response<GalleryResponse>
}