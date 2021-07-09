package com.jramirez.instamovies.presentation.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jramirez.instamovies.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by viewModels()
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvMovies.adapter
        }
        moviesViewModel.getMovies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}