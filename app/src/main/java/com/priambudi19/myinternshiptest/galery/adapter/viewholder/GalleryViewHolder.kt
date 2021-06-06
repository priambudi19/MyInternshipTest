package com.priambudi19.myinternshiptest.galery.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.priambudi19.myinternshiptest.R
import com.priambudi19.myinternshiptest.databinding.GalleryRowItemBinding
import com.priambudi19.myinternshiptest.galery.model.Gallery

class GalleryViewHolder(
    val binding: GalleryRowItemBinding,
    private val list: List<Gallery>
): RecyclerView.ViewHolder(binding.root)
{
    fun binds(position: Int){
        val data = list[position]
        binding.imgThumbnail.load(data.thumbnail){
            placeholder(R.drawable.ic_image_loading)
        }
    }
}