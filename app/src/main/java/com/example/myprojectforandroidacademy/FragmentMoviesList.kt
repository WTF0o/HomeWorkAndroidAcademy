package com.example.myprojectforandroidacademy

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.myprojectforandroidacademy.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {

    private var moviesListClickListener: MoviesListClickListener? = null
    private lateinit var fragmentBinding: FragmentMoviesListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBinding.cardView?.apply {
            setOnClickListener {
                moviesListClickListener?.openMovieDetails()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MoviesListClickListener) {
            moviesListClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        moviesListClickListener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return fragmentBinding?.root
    }

    interface MoviesListClickListener {
        fun openMovieDetails()
    }

}
