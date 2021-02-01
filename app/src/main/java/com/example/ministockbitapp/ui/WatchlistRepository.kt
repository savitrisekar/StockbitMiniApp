package com.example.ministockbitapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ministockbitapp.model.DataItem
import com.example.ministockbitapp.network.ApiClient
import java.lang.Exception
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class WatchlistRepository {
    private val apiClient = ApiClient().api()

    val showSuccess = MutableLiveData<List<DataItem>>()
    val showFailure = MutableLiveData<Boolean>()

    suspend fun getWatchlist() {
        try {
            val response = apiClient.getWatchlist()
            Log.d(TAG, "$response")

            if (response.isSuccessful) {
                Log.d(TAG, "SUCCESS")
                Log.d(TAG, "${response.body()}")

                showSuccess.postValue(response.body())
            } else {
                Log.d(TAG, "FAILURE")
                Log.d(TAG, "${response.body()}")

                showFailure.postValue(true)
            }
        } catch (e: UnknownHostException) {
            Log.e(TAG, e.message)
            showFailure.postValue(true)
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, e.message)
            showFailure.postValue(true)
        } catch (e: Exception) {
            Log.e(TAG, e.message)
            showFailure.postValue(true)
        }
    }

    companion object {
        val TAG = WatchlistRepository::class.java.simpleName
    }
}