package com.jramirez.instamovies.presentation.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jramirez.instamovies.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :
    ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _itemsLiveData = MutableLiveData<List<Any>>()
    val itemLiveData: LiveData<List<Any>> get() = _itemsLiveData

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getMoviesUseCase.execute()
            Log.d("UseCase", result.toString())
            _itemsLiveData.postValue(result)
        }
    }
}