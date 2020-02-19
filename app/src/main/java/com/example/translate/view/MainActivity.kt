package com.example.translate

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.translate.model.*
import com.example.translate.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), ViewInterface {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        translateBtnClicked()
        clearInputText()


    }

    private fun translateBtnClicked() {
        mainActivityTranslateBtn.setOnClickListener() {
            if (TextUtils.isEmpty(mainActivityInputWord.text)) {
                mainActivityInputWord.setError("Type word!...")
            } else {
                presenter.getWordFromView(mainActivityInputWord.text.toString())
                val hideKeyBoard: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                hideKeyBoard.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
            }
        }
    }

    private fun initPresenter() {
        presenter = MainPresenter()
        presenter.onAttach(this)
    }

    private fun clearInputText() {
        mainActivityImageBtn.setOnClickListener() {
            mainActivityInputWord.text.clear()
        }
    }


    override fun drawResult(result: ArrayList<String>) {
        if (result.size == 0) {
            Toast.makeText(this, "The word ''${mainActivityInputWord.text}'' was not Found!", Toast.LENGTH_LONG).show()
            mainActivityInputWord.text.clear()
        } else {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.WordsFragmentContainer, WordsFragment.fragmentInstance(result))
            transaction.addToBackStack("Previous page")
            transaction.commit()
            mainActivityTranslateBtn.visibility = View.INVISIBLE
            mainActivityImageBtn.visibility = View.INVISIBLE

        }
    }

    override fun onBackPressed() {
        mainActivityInputWord.text.clear()
        mainActivityTranslateBtn.visibility = View.VISIBLE
        mainActivityImageBtn.visibility = View.VISIBLE
        super.onBackPressed()
    }

    override fun onDestroy() {
        presenter.onDetouch()
        super.onDestroy()
    }

}

