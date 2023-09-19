package com.samra.movieappkotlin.service

import com.samra.movieappkotlin.model.ResultModel
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    //https://api.themoviedb.org/3/
    // trending/all/day?api_key=9e23cf92d2863070b9c4cf67c3ade35d
    @GET("trending/all/day?api_key=9e23cf92d2863070b9c4cf67c3ade35d")
    fun getAll(): Call<ResultModel>
}