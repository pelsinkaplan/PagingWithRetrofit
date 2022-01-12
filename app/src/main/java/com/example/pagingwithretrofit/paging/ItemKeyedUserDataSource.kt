package com.example.pagingwithretrofit.paging

import androidx.paging.PageKeyedDataSource
import com.example.pagingwithretrofit.api.Api
import com.example.pagingwithretrofit.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemKeyedUserDataSource : PageKeyedDataSource<Int, User>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        getProducts(callback)

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        val nextPageNo = params.key + 1
        getMoreProducts(params.key, nextPageNo, callback)

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        val previousPageNo = if (params.key > 1) params.key - 1 else 0
        getMoreProducts(params.key, previousPageNo, callback)

    }

    private fun getProducts(callback: LoadInitialCallback<Int, User>) {
        val retrofitService = Api()
        retrofitService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val products = response.body()
                products?.let { callback.onResult(it, null, 2) }
            }

        })

    }

    private fun getMoreProducts(pageNo: Int, previousOrNextPageNo: Int, callback: LoadCallback<Int, User>) {
        val retrofitService = Api()
        retrofitService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val products = response.body()
                products?.let { callback.onResult(it, previousOrNextPageNo) }
            }

        })

    }

}