package com.example.ministockbitapp.network

import com.example.ministockbitapp.model.DataItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("data/top/totaltoptiervolfull?limit=10&tsym=USD")
    suspend fun getWatchlist(): Response<List<DataItem>>
}