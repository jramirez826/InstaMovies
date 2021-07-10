package com.jramirez.instamovies.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jramirez.instamovies.data.model.Media
import com.jramirez.instamovies.databinding.FragmentDetailBinding
import com.jramirez.instamovies.presentation.base.BundleConstants
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpBinding()
    }

    private fun setUpBinding() {
        val movie = arguments?.getParcelable<Media>(BundleConstants.MOVIE)
        movie?.let {
            with(binding) {
                labTitle.text =
                    if (it.originalTitle.isNullOrEmpty()) it.originalName else it.originalTitle
                labOverview.text = it.overview
                labRating.text = it.voteAverage.toString()
                labReleaseDate.text =
                    if (it.releaseDate.isNullOrEmpty()) it.firstAirDate else it.releaseDate
                Picasso.get().load(it.posterPath).into(imgPoster)
            }
        }
    }
}