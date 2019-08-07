package com.example.mvvmposts.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmposts.R
import com.example.mvvmposts.databinding.ActivityUserDetailBinding
import com.example.mvvmposts.model.User

class UserDetailActivity: AppCompatActivity(){
    private lateinit var binding: ActivityUserDetailBinding
    private lateinit var viewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)
        viewModel = ViewModelProviders.of(this).get(UserDetailViewModel::class.java)
        val bundle: Bundle? = this.intent.extras
        val user = bundle!!.getSerializable("user") as User
        viewModel.bind(user)
        binding.viewModel = viewModel
    }
}