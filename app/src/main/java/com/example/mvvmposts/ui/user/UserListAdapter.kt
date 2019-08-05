package com.example.mvvmposts.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmposts.R
import com.example.mvvmposts.databinding.ItemUserBinding
import com.example.mvvmposts.model.User

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    private lateinit var userList:List<User>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.ViewHolder {
        val binding: ItemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_user, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListAdapter.ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return if(::userList.isInitialized) userList.size else 0
    }

    fun updateUserList(userList:List<User>){
        this.userList = userList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = UserViewModel()

        fun bind(user:User){
            viewModel.bind(user)
            binding.viewModel = viewModel
        }
    }
}
