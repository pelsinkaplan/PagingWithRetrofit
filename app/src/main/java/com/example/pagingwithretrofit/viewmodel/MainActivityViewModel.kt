package com.example.pagingwithretrofit.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.pagingwithretrofit.model.User
import com.example.pagingwithretrofit.paging.ItemKeyedUserDataSource
import com.example.pagingwithretrofit.paging.UserDataSourceFactory

class MainActivityViewModel
    (application: Application) : BaseViewModel(application) {

    private var products: LiveData<PagedList<User>> = MutableLiveData<PagedList<User>>()
    private var mutableLiveData = MutableLiveData<ItemKeyedUserDataSource>()

    init {
        val factory: UserDataSourceFactory by lazy {
            UserDataSourceFactory()
        }
        mutableLiveData = factory.mutableLiveData

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(6)
            .build()

        products = LivePagedListBuilder(factory, config)
            .build()

    }

    fun getData(): LiveData<PagedList<User>> {
        return products
    }

}
