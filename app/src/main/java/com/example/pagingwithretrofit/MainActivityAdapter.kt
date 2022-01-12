package com.example.pagingwithretrofit


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingwithretrofit.databinding.ItemUserBinding
import com.example.pagingwithretrofit.model.User

class MainActivityAdapter :
    PagedListAdapter<User, MainActivityAdapter.MyViewHolder>(USER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val user = getItem(position)

        if (user != null) {
            holder.itemBinding.userName.text = user.login
        }
    }

    class MyViewHolder(val itemBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private var binding: ItemUserBinding? = null

        init {
            this.binding = itemBinding
        }

    }

    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
                newItem == oldItem
        }
    }

}


