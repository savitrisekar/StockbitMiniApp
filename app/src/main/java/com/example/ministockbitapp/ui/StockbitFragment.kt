package com.example.ministockbitapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ministockbitapp.R

class StockbitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stockbit, container, false)

        val fm = activity?.getSupportFragmentManager()
        fm?.beginTransaction()
            ?.replace(R.id.frame_container, WatchlistFragment())
            ?.commit()

        return view
    }
}