package com.jramirez.instamovies.presentation.movies

import androidx.activity.ktx.R
import com.jramirez.instamovies.data.model.Movie
import com.jramirez.instamovies.databinding.ItemListBinding
import com.jramirez.instamovies.presentation.base.BaseViewHolder

class MoviesViewHolder(private val binding: ItemListBinding) :
    BaseViewHolder<Movie, ItemListBinding>(binding) {

    override fun bind(item: Movie) {
        with(binding) {
            imgPoster.setImageResource(R.drawable.notification_bg_normal)
        }
    }
}