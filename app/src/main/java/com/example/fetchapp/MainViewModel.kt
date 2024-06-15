package com.example.fetchapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repository = Repository()

    val items = liveData(Dispatchers.IO) {
        val retrievedItems = repository.getItems()
            .filter { !it.name.isNullOrBlank() }
            .sortedWith(compareBy({ it.listId }, { it.name }))
        emit(retrievedItems)
    }
}