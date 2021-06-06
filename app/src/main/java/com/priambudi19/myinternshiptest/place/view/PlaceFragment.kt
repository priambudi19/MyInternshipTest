package com.priambudi19.myinternshiptest.place.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.priambudi19.myinternshiptest.R
import com.priambudi19.myinternshiptest.databinding.FragmentPlaceBinding
import com.priambudi19.myinternshiptest.place.adapter.PlaceAdapter
import com.priambudi19.myinternshiptest.place.viewmodel.PlaceViewModel
import com.priambudi19.myinternshiptest.vo.Resource

class PlaceFragment : Fragment() {

    private val viewModel: PlaceViewModel by viewModels()
    private val binding: FragmentPlaceBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getListPlace().observe(viewLifecycleOwner, { content ->
            when (content) {
                is Resource.Success -> {
                    with(binding) {
                        val mAdapter = content.data?.content?.let { content ->
                            PlaceAdapter(
                                content
                            )
                        }
                        rvPlace.apply {
                            adapter = mAdapter
                            layoutManager = LinearLayoutManager(context)
                            progressBar.visibility = View.GONE
                            errorNotif.errorContainer.visibility = View.GONE
                            mAdapter?.onItemClick = { data ->
                                val bundle = Bundle()
                                bundle.putParcelable("place", data)
                                findNavController().navigate(
                                    R.id.action_placeFragment_to_detailPlaceFragment,
                                    bundle
                                )
                            }
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