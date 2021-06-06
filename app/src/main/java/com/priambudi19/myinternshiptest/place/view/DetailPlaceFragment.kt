package com.priambudi19.myinternshiptest.place.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.priambudi19.myinternshiptest.R
import com.priambudi19.myinternshiptest.databinding.FragmentDetailPlaceBinding
import com.priambudi19.myinternshiptest.place.model.Content
import com.priambudi19.myinternshiptest.place.model.Place


class DetailPlaceFragment : Fragment() {
    private var data: Content? = null
    private val binding: FragmentDetailPlaceBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = arguments?.getParcelable("place")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_detail_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
            if(data?.type=="multiple") {
                data?.media?.map {
                    imageList.add(SlideModel(it))
                }

            }else{
                imageList.add(SlideModel(data?.image))
            }
            with(binding){
                imageSlider.setImageList(imageList, scaleType = ScaleTypes.CENTER_CROP)
                txtTitle.text = data?.title
                txtSubtitle.text = data?.content
            }
        }




}