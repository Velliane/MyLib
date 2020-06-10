package com.menard.mylib.controller.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.menard.mylib.R

class ListsFragment : Fragment(){

    companion object{
        fun newInstance(): ListsFragment{
            return ListsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lists, container, false)

        return view
    }
}