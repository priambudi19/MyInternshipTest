package com.priambudi19.myinternshiptest.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priambudi19.myinternshiptest.network.repository.GaleryRepository
import com.priambudi19.myinternshiptest.network.repository.ProfileRepository
import com.priambudi19.myinternshiptest.profile.model.Profile
import com.priambudi19.myinternshiptest.vo.Resource

class ProfileViewModel : ViewModel() {
    private val repo = ProfileRepository(viewModelScope)
    fun getProfile(): LiveData<out Resource<Profile>> {
        val data = MutableLiveData<Resource<Profile>>(Resource.Loading())
        repo.getProfile(
            onSuccess = {
                data.postValue(Resource.Success(it))
            },
            onError = {
                data.postValue(Resource.Error(it.message))
            }
        )
        return data
    }
}