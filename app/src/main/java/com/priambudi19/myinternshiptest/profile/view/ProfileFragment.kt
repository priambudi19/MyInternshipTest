package com.priambudi19.myinternshiptest.profile.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.viewModels
import coil.load
import coil.transform.CircleCropTransformation
import com.priambudi19.myinternshiptest.R
import com.priambudi19.myinternshiptest.databinding.FragmentProfileBinding
import com.priambudi19.myinternshiptest.profile.viewmodel.ProfileViewModel
import com.priambudi19.myinternshiptest.vo.Resource


class ProfileFragment : Fragment() {
    private val viewModel: ProfileViewModel by viewModels()
    private val binding: FragmentProfileBinding by viewBinding()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProfile().observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Success -> {
                    with(binding) {
                        progressBar.visibility = View.GONE
                        errorNotif.errorContainer.visibility = View.GONE
                        imgProfile.load(it.data?.avatar) {
                            transformations(CircleCropTransformation())
                        }
                        txtName.text = it.data?.fullname
                        txtUsername.text = it.data?.username
                        txtEmail.text = it.data?.email
                        txtPhone.text = it.data?.phone
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