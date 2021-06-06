package com.priambudi19.myinternshiptest.place.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priambudi19.myinternshiptest.network.repository.GaleryRepository
import com.priambudi19.myinternshiptest.network.repository.PlaceRepository
import com.priambudi19.myinternshiptest.network.repository.ProfileRepository
import com.priambudi19.myinternshiptest.place.model.Place
import com.priambudi19.myinternshiptest.profile.model.Profile
import com.priambudi19.myinternshiptest.vo.Resource

class PlaceViewModel : ViewModel() {
    private val repo = PlaceRepository(viewModelScope)
    fun getListPlace(): LiveData<out Resource<Place>> {
        val data = MutableLiveData<Resource<Place>>(Resource.Loading())
        repo.getListPlace(
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