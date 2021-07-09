package com.jramirez.instamovies.presentation.base

import com.jramirez.instamovies.databinding.TitleItemListBinding
import com.jramirez.instamovies.domain.model.MovieGenre

class TitleViewHolder(private val binding: TitleItemListBinding) :
    BaseViewHolder<MovieGenre, TitleItemListBinding>(binding) {

    override fun bind(item: MovieGenre) {
        with(binding) {
            labTitle.text = item.title
        }
    }
}