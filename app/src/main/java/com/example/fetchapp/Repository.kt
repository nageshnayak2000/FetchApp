package com.example.fetchapp

class Repository {
    suspend fun getItems(): List<Item> {
        return RetrofitInstance.api.getItems()
    }
}