package com.samra.movieappkotlin.view

import android.os.Bundle
import android.text.Layout.Directions
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

import com.samra.movieappkotlin.R
import com.samra.movieappkotlin.adapter.MovieAdapter
import com.samra.movieappkotlin.databinding.FragmentMovieDetailsBinding
import com.samra.movieappkotlin.databinding.FragmentMovieListBinding
import com.samra.movieappkotlin.model.MovieModel
import com.samra.movieappkotlin.model.ResultModel
import com.samra.movieappkotlin.service.MovieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MovieList : Fragment(), MovieAdapter.Listener {

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var recyclerAdapter:MovieAdapter
    var BASE_URL = "https://api.themoviedb.org/3/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieListBinding.inflate(layoutInflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var layoutManager : RecyclerView.LayoutManager= GridLayoutManager(requireContext().applicationContext , 3)
        binding.recyclerView.layoutManager = layoutManager
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retrofit.create(MovieApi::class.java)


        var call = service.getAll()
        call.enqueue(object: Callback<ResultModel>{
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
               if(response.isSuccessful){
                   recyclerAdapter = MovieAdapter(response.body()!! , this@MovieList)
                   binding.recyclerView.adapter = recyclerAdapter
               }
            }

            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    override fun onItemCLick(movieModel: MovieModel, view: View) {
        var action  =MovieListDirections.actionMovieListToMovieDetails(movieModel.title, movieModel.overview , movieModel.release_date , movieModel.poster_path)
        Navigation.findNavController(view).navigate(action)
    }


}