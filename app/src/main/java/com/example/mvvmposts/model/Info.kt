package com.example.mvvmposts.model

import java.io.Serializable

data class Info (
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
):Serializable