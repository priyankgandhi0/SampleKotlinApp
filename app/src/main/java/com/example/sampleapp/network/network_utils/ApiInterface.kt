package com.example.sampleapp.network.network_utils


import com.example.sampleapp.model.ProductModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/products")
    suspend fun getProducts( @Query("limit") limit: Int,@Query("skip") skip: Int): Response<ProductModel>

    @GET("/products")
     fun getProducts2( @Query("limit") limit: Int,@Query("skip") skip: Int): Call<ProductModel>
}
