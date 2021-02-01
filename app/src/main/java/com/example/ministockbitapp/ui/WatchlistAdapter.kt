package com.example.ministockbitapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ministockbitapp.R
import com.example.ministockbitapp.model.DataItem

class WatchlistAdapter : RecyclerView.Adapter<WatchlistAdapter.ViewHolder>() {

    private var data: List<DataItem> = listOf()

    fun setData(dataList: List<DataItem>) {
        data = dataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_watchlist, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.nameCompany.text = data[position].coinInfo?.name
        holder.fullName.text = data[position].coinInfo?.fullName
        holder.price.text = data[position].rAW?.uSD?.pRICE
        holder.profit.text = data[position].rAW?.uSD?.cHANGE24HOUR
    }

    class ViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {
        val nameCompany = parent.findViewById<TextView>(R.id.tv_name)
        val fullName = parent.findViewById<TextView>(R.id.tv_full_name)
        val price = parent.findViewById<TextView>(R.id.tv_target_price)
        val profit = parent.findViewById<TextView>(R.id.tv_profit)
    }
}