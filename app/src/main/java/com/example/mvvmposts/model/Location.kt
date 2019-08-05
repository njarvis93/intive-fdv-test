package com.example.mvvmposts.model

data class Location (
	val street : String,
	val city : String,
	val state : String,
	val postcode : String,
	val coordinates : Coordinates,
	val timezone : Timezone
)