package com.ps_ovsyanka.googlesearchapp.ui

class MainActivityPresenter(){

    private lateinit var view: IMainActivityView

    fun onCreate(mainView: MainActivity){
        view = mainView
    }
}