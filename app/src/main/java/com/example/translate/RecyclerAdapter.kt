package com.example.translate

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.word_model.view.*

class RecyclerAdapter(val wordsArray : ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.WordsHolder>() {


    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsHolder {
        return WordsHolder(LayoutInflater.from(parent.context).inflate(R.layout.word_model, null))
    }

    override fun getItemCount(): Int {
        return wordsArray.size
    }

    override fun onBindViewHolder(holder: WordsHolder, position: Int) {
        holder.wordView.text = wordsArray.get(position)
    }

    class WordsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordView = itemView.wordModelItem
    }

}