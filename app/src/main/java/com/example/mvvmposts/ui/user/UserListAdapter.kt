package com.example.mvvmposts.ui.user

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmposts.R
import com.example.mvvmposts.databinding.ItemUserBinding
import com.example.mvvmposts.model.User
import java.io.Serializable

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    private lateinit var userList:List<User>
    private lateinit var activity:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.ViewHolder {
        val binding: ItemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_user, parent, false)
        activity = parent.context
        return ViewHolder(binding, activity)
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

    inner class ViewHolder(private val binding: ItemUserBinding,private val context: Context): RecyclerView.ViewHolder(binding.root){

        private val viewModel = UserViewModel()
        fun bind(user:User){
            viewModel.bind(user)
            binding.viewModel = viewModel
            binding.userCard.setOnClickListener{
                Log.d("Debug", "estoy dando click")
                val intent=Intent(context, UserDetailActivity::class.java)
                intent.putExtra("user", user)
               /* Log.e("object intent", intent.toString())
                Log.e("object extras", intent.extras.toString())
                val bundle: Bundle? = intent.extras
                Log.e("Object bundle", bundle.toString())
                bundle!!.putSerializable("user",user)
                intent.putExtras*/
                context.startActivity(intent)
            }
        }


    }

}
