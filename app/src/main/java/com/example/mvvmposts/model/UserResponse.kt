package com.example.mvvmposts.model

import java.io.Serializable

data class UserResponse (
    val results:List<User>,
    val info: Info
): Serializable