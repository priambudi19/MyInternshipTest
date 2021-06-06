package com.priambudi19.myinternshiptest.place.adapter.viewholder

import android.os.Bundle
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.priambudi19.myinternshiptest.R
import com.priambudi19.myinternshiptest.databinding.MultiplePlaceRowBinding
import com.priambudi19.myinternshiptest.place.adapter.MultiplePlaceAdapter
import com.priambudi19.myinternshiptest.place.adapter.PlaceAdapter
import com.priambudi19.myinternshiptest.place.model.Content

class MultipleViewHolder(
    val binding: MultiplePlaceRowBinding,
    private val list: List<Content>,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int) {
        val data = list[position]
        val multiplePlaceAdapter = MultiplePlaceAdapter(data.media)
        with(binding) {
            rvMultiplePlace.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = multiplePlaceAdapter
            }
            root.setOnClickListener {
                multiplePlaceAdapter.onItemClick?.invoke(data)
            }
            txtTitleMultiple.text = data.title
            txtSubtitleMultiple.text = data.content
        }
    }
}