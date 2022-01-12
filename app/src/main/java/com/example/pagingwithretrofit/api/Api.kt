package com.example.pagingwithretrofit.api

import com.example.pagingwithretrofit.model.User
import com.example.pagingwithretrofit.util.Constant
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


internal class Api {
    private val api = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun getUsers(): Call<List<User>> {
        return api.getUsers()
    }
}