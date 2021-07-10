package com.jramirez.instamovies.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jramirez.instamovies.data.model.Media
import com.jramirez.instamovies.databinding.ItemListBinding
import com.jramirez.instamovies.databinding.TitleItemListBinding
import com.jramirez.instamovies.domain.model.BaseGenre
import com.jramirez.instamovies.domain.model.MovieGenre
import com.jramirez.instamovies.presentation.base.*

class MediaAdapter(private val cellClickListener: CellClickListener<Media>? = null) :
    RecyclerView.Adapter<BaseViewHolder<*, *>>() {

    private val items: MutableList<Any> = mutableListOf()

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        val comparable = items[position]
        return when (comparable) {
            is Media -> AdapterViewType.ITEM.ordinal
            is BaseGenre -> AdapterViewType.TITLE.ordinal
            else -> throw IllegalArgumentException("View Type not supported in $position")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        return when (viewType) {
            AdapterViewType.TITLE.ordinal -> {
                val binding =
                    TitleItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                TitleViewHolder(binding)
            }
            AdapterViewType.ITEM.ordinal -> {
                val binding =
                    ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MediaViewHolder(binding)
            }
            else -> throw IllegalArgumentException("View Type not supported")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*, *>, position: Int) {
        val item = items[position]
        when (holder) {
            is MediaViewHolder -> holder.bind(item as Media, cellClickListener)
            is TitleViewHolder -> holder.bind(item as BaseGenre, null)
            else -> throw IllegalArgumentException()
        }
    }

    fun updateItems(newItems: List<Any>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

}