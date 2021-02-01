package com.example.ministockbitapp.ui

import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.ministockbitapp.R
import kotlinx.android.synthetic.main.fragment_watchlist.*

class WatchlistFragment : Fragment() {

    private lateinit var viewModel: WatchlistViewModel
    private lateinit var adapterStock: WatchlistAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_watchlist, container, false)

        viewModel = ViewModelProviders.of(this).get(WatchlistViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setupRecyclerView()
        setupObservers()

        viewModel.getWatchlist()

//        tv_name_stock.text = arguments?.getString("nameArgs")
    }

    private fun initView() {
        swipe.setOnRefreshListener {
            Handler().postDelayed(Runnable {
                swipe.isRefreshing = false
            }, 2000)
        }
    }

    private fun setupRecyclerView() {
        adapterStock = WatchlistAdapter()
        rv_watchlist.layoutManager = LinearLayoutManager(requireContext())
        rv_watchlist.adapter = adapterStock
    }

    private fun setupObservers() {
        viewModel.showSuccess.observe(viewLifecycleOwner, Observer { watchList ->

            watchList?.let {
                adapterStock.setData(it)
                progressbar.visibility = View.GONE
            }
        })

        viewModel.showFailure.observe(viewLifecycleOwner, Observer { isFailed ->

            isFailed?.let {
                Toast.makeText(context, "Oops! something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }
}