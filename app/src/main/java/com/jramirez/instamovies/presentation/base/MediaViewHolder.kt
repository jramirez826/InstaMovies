package com.jramirez.instamovies.presentation.base

import com.jramirez.instamovies.data.model.Media
import com.jramirez.instamovies.databinding.ItemListBinding
import com.jramirez.instamovies.presentation.base.BaseViewHolder
import com.jramirez.instamovies.presentation.base.CellClickListener
import com.squareup.picasso.Picasso

class MediaViewHolder(private val binding: ItemListBinding) :
    BaseViewHolder<Media, ItemListBinding>(binding) {

    override fun bind(item: Media, cellClickListener: CellClickListener<Media>?) {
        with(binding) {
            Picasso.get().load(item.posterPath).into(imgPoster)
            labTitle.text =
                if (item.originalTitle.isNullOrEmpty()) item.originalName else item.originalTitle
            root.setOnClickListener {
                cellClickListener?.onCellClickListener(item, it)
            }
        }
    }
}