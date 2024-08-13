package com.example.e2logy_sahil.repository

import com.example.e2logy_sahil.network.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductRepository {

    private val BASE_URL = "https://dl.dropboxusercontent.com"
    private val api: ApiInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        api = retrofit.create(ApiInterface::class.java)
    }

    fun getProducts() = api.getData()
}
