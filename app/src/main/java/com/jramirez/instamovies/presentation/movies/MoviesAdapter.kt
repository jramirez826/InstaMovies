package com.jramirez.instamovies.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jramirez.instamovies.data.model.Movie
import com.jramirez.instamovies.databinding.ItemListBinding
import com.jramirez.instamovies.databinding.TitleItemListBinding
import com.jramirez.instamovies.domain.model.MovieGenre
import com.jramirez.instamovies.presentation.base.AdapterViewType
import com.jramirez.instamovies.presentation.base.BaseViewHolder
import com.jramirez.instamovies.presentation.base.TitleViewHolder

class MoviesAdapter : RecyclerView.Adapter<BaseViewHolder<*, *>>() {

    private val items: MutableList<Any> = mutableListOf()

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        val comparable = items[position]
        return when (comparable) {
            is Movie -> AdapterViewType.ITEM.ordinal
            is MovieGenre -> AdapterViewType.TITLE.ordinal
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
                MoviesViewHolder(binding)
            }
            else -> throw IllegalArgumentException("View Type not supported")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*, *>, position: Int) {
        val item = items[position]
        when (holder) {
            is MoviesViewHolder -> holder.bind(item as Movie)
            is TitleViewHolder -> holder.bind(item as MovieGenre)
            else -> throw IllegalArgumentException()
        }
    }

    fun updateItems(newItems: List<Any>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

}