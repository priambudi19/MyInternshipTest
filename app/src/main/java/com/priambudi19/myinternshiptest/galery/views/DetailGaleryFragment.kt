package com.priambudi19.myinternshiptest.galery.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import coil.load
import com.priambudi19.myinternshiptest.R
import com.priambudi19.myinternshiptest.databinding.FragmentDetailGaleryBinding
import com.priambudi19.myinternshiptest.galery.model.Gallery

class DetailGaleryFragment : Fragment() {
    private var data : Gallery? = null
    private val binding : FragmentDetailGaleryBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = arguments?.getParcelable("gallery")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_galery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            squareImageView.load(data?.image){
                placeholder(R.drawable.ic_image_loading)
            }
            txtCaption.text = data?.caption
        }
    }


}