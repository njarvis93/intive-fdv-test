package com.example.mvvmposts.ui.user

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmposts.R
import com.example.mvvmposts.databinding.ItemUserBinding
import com.example.mvvmposts.model.User
import java.math.MathContext

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    private lateinit var userList:List<User>
    private lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.ViewHolder {
        val binding: ItemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_user, parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListAdapter.ViewHolder, position: Int) {
        holder.bind(userList[position])
        //context= holder.itemView.context
    }

    override fun getItemCount(): Int {
        return if(::userList.isInitialized) userList.size else 0
    }

    fun updateUserList(userList:List<User>){
        this.userList = userList
        notifyDataSetChanged()
    }

    public val onClickListenerCardView : OnClickListener = OnClickListener { view ->
        Log.d("Debug", "estoy dando click")
    }


    class ViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = UserViewModel()

        fun bind(user:User){
            viewModel.bind(user)
            binding.viewModel = viewModel
            binding.userCard.setOnClickListener{  }
        }
    }
}
