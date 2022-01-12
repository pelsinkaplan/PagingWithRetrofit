package com.example.pagingwithretrofit.api

import com.example.pagingwithretrofit.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}