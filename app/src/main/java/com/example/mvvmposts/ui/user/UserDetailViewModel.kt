package com.example.mvvmposts.ui.user

import androidx.lifecycle.MutableLiveData
import com.example.mvvmposts.base.BaseViewModel
import com.example.mvvmposts.model.User

class UserDetailViewModel: BaseViewModel() {
    private val largeImageUser = MutableLiveData<String>()
    private val nameUser = MutableLiveData<String>()
    private val username = MutableLiveData<String>()
    private val email = MutableLiveData<String>()

    fun bind(user: User){
        largeImageUser.value = user.picture.large
        nameUser.value = (user.name.title+" "+user.name.first+" "+user.name.last).toUpperCase()
        username.value = user.login.username
        email.value = user.email
    }
    fun getLargeImageUser():MutableLiveData<String>{
        return largeImageUser
    }
    fun getNameUser():MutableLiveData<String>{
        return nameUser
    }
    fun getUsername():MutableLiveData<String>{
        return username
    }
    fun getEmail():MutableLiveData<String>{
        return email
    }

}