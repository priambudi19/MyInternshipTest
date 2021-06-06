package com.priambudi19.myinternshiptest.place.adapter

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.priambudi19.myinternshiptest.databinding.MultiplePlaceRowBinding
import com.priambudi19.myinternshiptest.databinding.SinglePlaceRowBinding
import com.priambudi19.myinternshiptest.place.adapter.viewholder.MultipleViewHolder
import com.priambudi19.myinternshiptest.place.adapter.viewholder.SingleViewHolder
import com.priambudi19.myinternshiptest.place.model.Content

class PlaceAdapter(
    private val list: List<Content>,
    var onItemClick: ((Content) -> Unit)? = null
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_SINGLE) {
            return SingleViewHolder(
                SinglePlaceRowBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), list
            )
        } else {
            return MultipleViewHolder(
                MultiplePlaceRowBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), list
            )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position].getViewType() == VIEW_TYPE_MULTIPLE) {
            val multipleViewHolder = (holder as MultipleViewHolder)
            multipleViewHolder.bind(position)

            multipleViewHolder.binding.multiplePlace.setOnClickListener{
                onItemClick?.invoke(list[position])
            }
        } else {
            val singleViewHolder = (holder as SingleViewHolder)
            singleViewHolder.bind(position)
            singleViewHolder.binding.root.setOnClickListener {
                onItemClick?.invoke(list[position])
            }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = list[position].getViewType()

    companion object {
        private const val VIEW_TYPE_SINGLE = 1
        private const val VIEW_TYPE_MULTIPLE = 2
        private fun Content.getViewType(): Int {
            return if (this.type == "multiple") {
                VIEW_TYPE_MULTIPLE
            } else {
                VIEW_TYPE_SINGLE
            }
        }
    }


}