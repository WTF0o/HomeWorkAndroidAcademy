package com.example.myprojectforandroidacademy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentMoviesList.MoviesListClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(R.id.container, FragmentMoviesList())
                .commit()
        }
    }

    override fun openMovieDetails() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, FragmentMoviesDetails())
            .commit()
    }

}