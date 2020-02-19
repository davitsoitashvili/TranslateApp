package com.example.translate.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiHolder {
    @GET("{word}")
    fun getTranslatedWord(@Path("word") word : String) : Call<Row>
}