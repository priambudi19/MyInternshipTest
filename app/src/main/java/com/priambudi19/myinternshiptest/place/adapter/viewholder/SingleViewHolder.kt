package com.priambudi19.myinternshiptest.place.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.priambudi19.myinternshiptest.databinding.SinglePlaceRowBinding
import com.priambudi19.myinternshiptest.place.adapter.PlaceAdapter
import com.priambudi19.myinternshiptest.place.model.Content

class SingleViewHolder(
    val binding: SinglePlaceRowBinding,
    private val list: List<Content>
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int) {
        val data = list[position]
        with(binding) {
            imageView.load(data.image)
            txtTitle.text = data.title
            txtSubtitle.text = data.content
        }
    }
}