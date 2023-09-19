package com.samra.movieappkotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.samra.movieappkotlin.R
import com.samra.movieappkotlin.databinding.FragmentMovieDetailsBinding
import com.squareup.picasso.Picasso


class MovieDetails : Fragment() {
    private lateinit var binding:FragmentMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            var name = MovieDetailsArgs.fromBundle(it).name
            var overview = MovieDetailsArgs.fromBundle(it).overview
            var date = MovieDetailsArgs.fromBundle(it).date
            var imagePath = MovieDetailsArgs.fromBundle(it).imagePath

            var imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
            var imageUrl = imageBaseUrl+imagePath

            binding.movieNameDetail.setText(name)
            binding.movieOverviewDetail.setText(overview)
            binding.movieDateDetail.setText(date)
            Picasso.get().load(imageUrl).into(binding.movieImageDetail)

        }

        binding.backButton.setOnClickListener {
            var action = MovieDetailsDirections.actionMovieDetailsToMovieList()
            Navigation.findNavController(it).navigate(action)
        }


    }


}