package com.example.myprojectforandroidacademy

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myprojectforandroidacademy.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {

    private var mMoviesListClickListener: MoviesListClickListener? = null
    private var mFragmentBinding: FragmentMoviesListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentBinding?.containerMovieItem?.root?.apply {
            setOnClickListener {
                mMoviesListClickListener?.openMovieDetails()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MoviesListClickListener) {
            mMoviesListClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        mMoviesListClickListener = null
        mFragmentBinding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mFragmentBinding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return mFragmentBinding?.root
    }

    interface MoviesListClickListener {
        fun openMovieDetails()
    }

}
