package com.example.translate.model

import android.widget.Toast
import com.example.translate.MainActivity
import retrofit2.Call
import retrofit2.Response

@Suppress("NAME_SHADOWING")
class ResponseHandlerModel {

    fun getWordFromPresenter(word: String, wordArrayCallback: (ArrayList<String>) -> Unit) {
        val wordArray = ArrayList<String>()
        val call = apiHolder.getTranslatedWord(word)
        call.enqueue(object : retrofit2.Callback<Row> {
            override fun onFailure(call: Call<Row>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Row>, response: Response<Row>) {
                if (response.body() != null) {
                    val listValue = response.body()!!.row
                    for (word in listValue) {
                        wordArray.add(word.value.word)
                    }
                    wordArrayCallback(wordArray)
                }

            }
        })

    }
}