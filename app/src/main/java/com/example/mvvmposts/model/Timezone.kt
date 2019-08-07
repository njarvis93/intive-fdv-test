package com.example.mvvmposts.model

import java.io.Serializable

data class Timezone (
	val offset : String,
	val description : String
): Serializable