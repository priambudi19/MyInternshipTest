package com.priambudi19.myinternshiptest.galery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.priambudi19.myinternshiptest.databinding.GalleryRowItemBinding
import com.priambudi19.myinternshiptest.galery.adapter.viewholder.GalleryViewHolder
import com.priambudi19.myinternshiptest.galery.model.Gallery

class GalleryAdapter(private val list: List<Gallery>) : RecyclerView.Adapter<GalleryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            GalleryRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            list
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.binds(position)
        holder.binding.imgThumbnail.setOnClickListener { onItemClick?.invoke(list[position]) }
    }

    override fun getItemCount(): Int = list.size

    var onItemClick: ((Gallery) -> Unit)? = null
}