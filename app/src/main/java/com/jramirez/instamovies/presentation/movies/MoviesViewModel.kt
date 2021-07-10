package com.jramirez.instamovies.presentation.movies

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jramirez.instamovies.data.model.Media
import com.jramirez.instamovies.domain.usecase.GetMoviesUseCase
import com.jramirez.instamovies.presentation.base.BundleConstants
import com.jramirez.instamovies.presentation.base.CellClickListener
import com.jramirez.instamovies.presentation.base.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :
    ViewModel(), CellClickListener<Media> {

    private val _itemsLiveData = MutableLiveData<List<Any>>()
    val itemLiveData: LiveData<List<Any>> get() = _itemsLiveData

    val bundleLiveData = SingleLiveData<Bundle>()

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getMoviesUseCase.execute()
            Log.d("UseCase", result.toString())
            _itemsLiveData.postValue(result)
        }
    }

    override fun onCellClickListener(item: Media, view: View) {
        val bundle = Bundle().apply {
            putParcelable(BundleConstants.MOVIE, item)
        }
        bundleLiveData.value = bundle
    }
}