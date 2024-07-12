package com.example.sampleapp.network.network_utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
      const val BaseUrl = "https://dummyjson.com/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}
