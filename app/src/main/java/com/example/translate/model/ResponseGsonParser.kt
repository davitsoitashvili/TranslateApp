package com.example.translate.model

import com.google.gson.annotations.SerializedName

data class Row(
    @SerializedName("rows")
    val row : List<Value>
)

data class Value (
    @SerializedName("value")
    val value : Word
)

data class Word(
    @SerializedName("Text")
    val word: String
)