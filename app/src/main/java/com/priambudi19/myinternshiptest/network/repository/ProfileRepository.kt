package com.priambudi19.myinternshiptest.network.repository

import com.priambudi19.myinternshiptest.network.SafeApiRequest
import com.priambudi19.myinternshiptest.network.ServiceFactory
import com.priambudi19.myinternshiptest.network.rest.RestApiProfile
import com.priambudi19.myinternshiptest.profile.model.Profile
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ProfileRepository(private val scope: CoroutineScope) : SafeApiRequest() {
    private val api = ServiceFactory.getApiService(RestApiProfile::class.java)
    fun getProfile(onSuccess: (Profile?) -> Unit, onError:(Exception) -> Unit){
        scope.launch {
            try {
                val result = apiRequest { api.getProfile() }
                onSuccess(result?.data)
            } catch (e: Exception) {
                if (e !is CancellationException) {
                    onError(e)
                }
            }
        }
    }
}