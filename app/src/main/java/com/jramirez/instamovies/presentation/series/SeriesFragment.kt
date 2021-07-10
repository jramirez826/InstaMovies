package com.jramirez.instamovies.presentation.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jramirez.instamovies.R
import com.jramirez.instamovies.databinding.FragmentMediaBinding
import com.jramirez.instamovies.presentation.base.MediaAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment : Fragment() {

    private val seriesViewModel: SeriesViewModel by viewModels()
    private var _binding: FragmentMediaBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MediaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMediaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpBinding()
        setUpLiveData()
        seriesViewModel.getSeries()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpBinding() {
        with(binding) {
            adapter = MediaAdapter(seriesViewModel)
            rvMovies.adapter = adapter
        }
    }

    private fun setUpLiveData() {
        seriesViewModel.itemLiveData.observe(viewLifecycleOwner, {
            adapter.updateItems(it)
        })
        seriesViewModel.bundleLiveData.observe(viewLifecycleOwner, {
            findNavController().navigate(R.id.action_navigation_series_to_navigation_detail, it)
        })
    }
}