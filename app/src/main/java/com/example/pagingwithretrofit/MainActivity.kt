package com.example.pagingwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingwithretrofit.model.User
import com.example.pagingwithretrofit.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    val adapter = MainActivityAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tempViewModel: MainActivityViewModel by viewModels()
        this.viewModel = tempViewModel

        findViewById<RecyclerView>(R.id.home_page_recyclerview).adapter = adapter

        viewModel.getData().observe(this, object : Observer<PagedList<User>> {
            override fun onChanged(t: PagedList<User>?) {
                adapter.submitList(t)
            }
        })
    }
}