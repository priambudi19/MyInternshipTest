package com.priambudi19.myinternshiptest.galery.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.priambudi19.myinternshiptest.R
import com.priambudi19.myinternshiptest.databinding.FragmentGalleryBinding
import com.priambudi19.myinternshiptest.galery.adapter.GalleryAdapter
import com.priambudi19.myinternshiptest.galery.viewmodel.GalleryViewModel
import com.priambudi19.myinternshiptest.vo.Resource


class GalleryFragment : Fragment() {
    private val binding: FragmentGalleryBinding by viewBinding()
    private val viewModel: GalleryViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getListGalery().observe(viewLifecycleOwner, { it ->
            when (it) {
                is Resource.Success -> {
                    with(binding) {
                        val mAdapter = it.data?.let { gallery -> GalleryAdapter(gallery) }
                        progressBar.visibility = View.GONE
                        errorNotif.errorContainer.visibility = View.GONE
                        rvGallery.apply {
                            adapter = mAdapter
                        }
                        mAdapter?.onItemClick = { data ->
                            val bundle = Bundle()
                            bundle.putParcelable("gallery", data)
                            findNavController().navigate(
                                R.id.action_galleryFragment_to_detailGaleryFragment,
                                bundle
                            )
                        }
                    }

                }
                is Resource.Error -> {
                    with(binding) {
                        progressBar.visibility = View.GONE
                        errorNotif.errorContainer.visibility = View.VISIBLE
                    }

                }
                is Resource.Loading -> {
                    with(binding) {
                        progressBar.visibility = View.VISIBLE
                        errorNotif.errorContainer.visibility = View.GONE
                    }

                }
            }
        })
    }


}