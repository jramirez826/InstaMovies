package com.jramirez.instamovies.presentation.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.jramirez.instamovies.R
import com.jramirez.instamovies.databinding.FragmentMediaBinding
import com.jramirez.instamovies.presentation.base.MediaAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by viewModels()
    private var _binding: FragmentMediaBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MediaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val appBarConfig = AppBarConfiguration(setOf(R.id.navigation_movies))
        NavigationUI.navigateUp(findNavController(), appBarConfig)
        _binding = FragmentMediaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpBinding()
        setUpLiveData()
        moviesViewModel.getMovies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpBinding() {
        with(binding) {
            adapter = MediaAdapter(moviesViewModel)
            rvMovies.adapter = adapter
        }
    }

    private fun setUpLiveData() {
        moviesViewModel.itemLiveData.observe(viewLifecycleOwner, {
            adapter.updateItems(it)
        })
        moviesViewModel.bundleLiveData.observe(viewLifecycleOwner, {
            findNavController().navigate(R.id.action_navigation_movies_to_navigation_detail, it)
        })
    }
}