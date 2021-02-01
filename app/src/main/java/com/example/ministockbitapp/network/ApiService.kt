package com.example.ministockbitapp.network

import com.example.ministockbitapp.model.DataItem
import com.example.ministockbitapp.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("data/top/totaltoptiervolfull?limit=50&tsym=USD")
    suspend fun getWatchlist(): Response<ResponseModel>
}