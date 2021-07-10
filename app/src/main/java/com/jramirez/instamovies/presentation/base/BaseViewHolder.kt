package com.jramirez.instamovies.presentation.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T, B : ViewBinding>(binding: B) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T, cellClickListener: CellClickListener<T>?)
}