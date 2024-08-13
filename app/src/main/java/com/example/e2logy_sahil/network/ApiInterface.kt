package com.example.e2logy_sahil.network

import com.example.e2logy_sahil.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/s/p57gxwqm84zkp96/demo_api.json")
    fun getData(): Call<Products>
}
