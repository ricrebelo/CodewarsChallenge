package com.codewars.challenge.web

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiManager @Inject constructor() {

    companion object {
        private const val BASE_URL = "https://www.codewars.com/api/v1/"
    }

    fun build() : Endpoints = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Endpoints::class.java)
}

