package com.example.translate


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_words.*

class WordsFragment : Fragment() {

    lateinit var wordsArray : ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_words, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        wordsArray = this.arguments?.getStringArrayList("words")!!
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()


    }

    companion object {
        fun fragmentInstance(words : ArrayList<String>) : WordsFragment {
            val bundle = Bundle()
            bundle.putStringArrayList("words",words)
            val fragment = WordsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private fun initRecyclerView() {
        val recyclerAdapter = RecyclerAdapter(wordsArray)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = GridLayoutManager(view!!.context,1)
        recyclerAdapter.notifyDataSetChanged()
    }

}
