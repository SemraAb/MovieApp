package com.samra.movieappkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samra.movieappkotlin.databinding.RecyclerRowBinding
import com.samra.movieappkotlin.model.MovieModel
import com.samra.movieappkotlin.model.ResultModel
import com.squareup.picasso.Picasso

class MovieAdapter(private var movieModel: ResultModel ,  private var listener:Listener ): RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    interface Listener{
        fun onItemCLick(movieModel: MovieModel , view:View)
    }

    class MovieHolder(var binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun clickImage(movieItem: MovieModel , listener: Listener){
            itemView.setOnClickListener{
                listener.onItemCLick(movieItem , it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        var binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return MovieHolder(binding)
    }

    override fun getItemCount(): Int {
     return movieModel.results.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        var image_path = "https://image.tmdb.org/t/p/w500/"

        holder.binding.movieName.text = movieModel.results[position].title
        Picasso.get().load(image_path+movieModel.results[position].poster_path).into(holder.binding.movieImage)
        holder.clickImage(movieModel.results[position] , listener)
    }
}