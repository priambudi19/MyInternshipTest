package com.priambudi19.myinternshiptest.place.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.priambudi19.myinternshiptest.databinding.ChildPlaceRowBinding
import com.priambudi19.myinternshiptest.place.model.Content

class MultiplePlaceAdapter(val listImageLink: List<String>) :
    RecyclerView.Adapter<MultiplePlaceAdapter.ListViewHolder>() {
    class ListViewHolder(val binding: ChildPlaceRowBinding) : RecyclerView.ViewHolder(binding.root)
    var onItemClick : ((Content) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ChildPlaceRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.imageView2.load(listImageLink[position])
    }

    override fun getItemCount(): Int = listImageLink.size
}