package com.jramirez.instamovies.presentation.base

import android.view.View

interface CellClickListener<T> {
    fun onCellClickListener(
        item: T, view: View
    )
}