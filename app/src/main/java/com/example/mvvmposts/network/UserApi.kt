package com.example.mvvmposts.network

import com.example.mvvmposts.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi {

    @GET("?results=50")
    fun getUsers(): Observable<UserResponse>
}