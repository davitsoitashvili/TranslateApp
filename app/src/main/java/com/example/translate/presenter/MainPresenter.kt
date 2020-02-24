package com.example.translate.presenter

import com.example.translate.MainActivity
import com.example.translate.ViewInterface
import com.example.translate.model.ResponseHandlerModel


class MainPresenter {

    private var mainView: ViewInterface? = null
    private val responseHandlerModel = ResponseHandlerModel()


    fun onAttach(mainView: ViewInterface) {
        this.mainView = mainView
    }

    fun onDetouch() {
        this.mainView = null
    }

    fun getWordFromView(word: String) {
        responseHandlerModel.getWordFromPresenter(word) {
            mainView?.drawResult(it)
        }
    }

}