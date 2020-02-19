package com.example.translate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.translate.model.*
import com.example.translate.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), ViewInterface {

    lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        translateBtnClicked()

    }

    private fun translateBtnClicked() {
        mainActivityTranslateBtn.setOnClickListener() {
            presenter.getWordFromView(mainActivityInputWord.text.toString())
        }
    }

    private fun initPresenter() {
        presenter = MainPresenter()
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetouch()
        super.onDestroy()
    }

    override fun drawResult(result: MutableList<String>) {

    }

}

