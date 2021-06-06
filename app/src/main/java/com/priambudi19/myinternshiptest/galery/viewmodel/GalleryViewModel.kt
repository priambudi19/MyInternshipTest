package com.priambudi19.myinternshiptest.galery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priambudi19.myinternshiptest.galery.model.Gallery
import com.priambudi19.myinternshiptest.network.repository.GaleryRepository
import com.priambudi19.myinternshiptest.network.repository.PlaceRepository
import com.priambudi19.myinternshiptest.place.model.Place
import com.priambudi19.myinternshiptest.vo.Resource

class GalleryViewModel : ViewModel() {
    private val repo = GaleryRepository(viewModelScope)

    fun getListGalery(): LiveData<out Resource<List<Gallery>>> {
        val data = MutableLiveData<Resource<List<Gallery>>>(Resource.Loading())
        repo.getListGallery(
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