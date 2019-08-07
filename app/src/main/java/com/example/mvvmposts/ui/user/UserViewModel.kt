package com.example.mvvmposts.ui.user

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import com.example.mvvmposts.base.BaseViewModel
import com.example.mvvmposts.model.User
import java.io.IOException
import java.net.URL


class UserViewModel: BaseViewModel() {
    private val thumbnailUser = MutableLiveData<String>()
    private val nameUser = MutableLiveData<String>()

    fun bind(user: User){
        thumbnailUser.value = user.picture.thumbnail
        nameUser.value = (user.name.title +" "+user.name.first).toUpperCase()
    }

    fun getThumbnailUser():MutableLiveData<String>{
        return thumbnailUser
    }

    fun getNameUser():MutableLiveData<String>{
        return nameUser
    }


}