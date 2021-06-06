package com.priambudi19.myinternshiptest.network.repository

import com.priambudi19.myinternshiptest.galery.model.Gallery
import com.priambudi19.myinternshiptest.network.SafeApiRequest
import com.priambudi19.myinternshiptest.network.ServiceFactory
import com.priambudi19.myinternshiptest.network.rest.RestApiGalery
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class GaleryRepository (private val scope: CoroutineScope) : SafeApiRequest() {
    private val api =ServiceFactory.getApiService(RestApiGalery::class.java)
    fun getListGallery(onSuccess: (List<Gallery>?) -> Unit, onError:(Exception) -> Unit) {
        scope.launch {
            try {
                val result = apiRequest { api.getListGallery() }
                onSuccess(result?.data)
            } catch (e: Exception) {
                if (e !is CancellationException) {
                    onError(e)
                }
            }
        }
    }
}