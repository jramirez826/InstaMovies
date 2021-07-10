package com.jramirez.instamovies.presentation.base

import com.jramirez.instamovies.databinding.TitleItemListBinding
import com.jramirez.instamovies.domain.model.BaseGenre

class TitleViewHolder(private val binding: TitleItemListBinding) :
    BaseViewHolder<BaseGenre, TitleItemListBinding>(binding) {

    override fun bind(item: BaseGenre, cellClickListener: CellClickListener<BaseGenre>?) {
        with(binding) {
            labTitle.text = item.title()
        }
    }
}