package com.example.translate.model

import android.widget.Toast
import com.example.translate.MainActivity
import retrofit2.Call
import retrofit2.Response

class ResponseHandlerModel {

    fun getWordFromPresenter(word : String, wordArrayCallback : (MutableList<String>) -> Unit) {
        val wordArray = mutableListOf<String>()
        val call = apiHolder.getTranslatedWord("car")
        call.enqueue(object : retrofit2.Callback<Row> {
            override fun onFailure(call: Call<Row>, t: Throwable) {
                t.printStackTrace()
            }
            override fun onResponse(call: Call<Row>, response: Response<Row>) {
                val listValue = response.body()!!.row
                for (word in listValue) {
                   wordArray.add(word.value.word)
                }
                wordArrayCallback.invoke(wordArray)

            }
        })

    }
}