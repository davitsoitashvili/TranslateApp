package com.example.translate.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL = "https://translate.ge/api/"

private val retrofit : Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var apiHolder : ApiHolder = retrofit.create(ApiHolder::class.java)
