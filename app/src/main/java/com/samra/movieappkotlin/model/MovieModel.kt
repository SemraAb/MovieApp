package com.samra.movieappkotlin.model

data class MovieModel(
    var id : Int ,
    var title : String,
    var overview: String,
    var release_date: String,
    var poster_path: String
) {

}