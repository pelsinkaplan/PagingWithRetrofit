package com.example.pagingwithretrofit.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.pagingwithretrofit.model.User


class UserDataSourceFactory: DataSource.Factory<Int, User>() {

    val mutableLiveData = MutableLiveData<ItemKeyedUserDataSource>()

    override fun create(): DataSource<Int, User> {
        val productDataSource = ItemKeyedUserDataSource()
        mutableLiveData.postValue(productDataSource)
        return productDataSource
    }
}