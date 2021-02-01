package com.example.ministockbitapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WatchlistViewModel : ViewModel() {

    private val repository = WatchlistRepository()

    val showSuccess = repository.showSuccess
    val showFailure = repository.showFailure

    fun getWatchlist() {
        viewModelScope.launch { repository.getWatchlist() }
    }
}