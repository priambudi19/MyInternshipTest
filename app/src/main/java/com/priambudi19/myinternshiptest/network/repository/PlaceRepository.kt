package com.priambudi19.myinternshiptest.network.repository

import com.priambudi19.myinternshiptest.network.SafeApiRequest
import com.priambudi19.myinternshiptest.network.ServiceFactory
import com.priambudi19.myinternshiptest.network.rest.RestApiPlace
import com.priambudi19.myinternshiptest.place.model.Place
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class PlaceRepository(private val scope: CoroutineScope) : SafeApiRequest() {
    private val api = ServiceFactory.getApiService(RestApiPlace::class.java)
    fun getListPlace(onSuccess: (Place?) -> Unit, onError:(Exception) -> Unit){
        scope.launch {
            try {
                val result = apiRequest { api.getListPlace() }
                onSuccess(result?.data)
            } catch (e: Exception) {
                if (e !is CancellationException) {
                    onError(e)
                }
            }
        }
    }
}