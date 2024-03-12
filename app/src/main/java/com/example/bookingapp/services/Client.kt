package com.example.bookingapp.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    fun getClient(baseURL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}