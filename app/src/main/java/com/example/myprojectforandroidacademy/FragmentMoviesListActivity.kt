package com.example.myprojectforandroidacademy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class FragmentMoviesListActivity : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var moviesDetailsActivity: MoviesListClickListener? = null;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MoviesListClickListener) {
            moviesDetailsActivity = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        moviesDetailsActivity = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        view?.findViewById<CardView>(R.id.cardView)?.apply {
            setOnClickListener {
                moviesDetailsActivity?.openMovieDetails()
            }
        }
        return view
    }

    interface MoviesListClickListener {
        fun openMovieDetails()
    }


}
