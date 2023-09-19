package com.samra.movieappkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.samra.movieappkotlin.R
import com.samra.movieappkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //https://api.themoviedb.org/3/trending/all/day?api_key=9e23cf92d2863070b9c4cf67c3ade35d



    }
}