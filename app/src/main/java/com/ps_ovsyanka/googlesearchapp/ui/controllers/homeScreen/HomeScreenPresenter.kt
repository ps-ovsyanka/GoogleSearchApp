package com.ps_ovsyanka.googlesearchapp.ui.controllers.homeScreen

class HomeScreenPresenter {

    lateinit var mainView: IHomeScreenView

    fun onCreate(view: IHomeScreenView){
        mainView = view
    }

    fun onClickBtnSearch() {
        mainView.toSearchScreen()
    }

    fun onClickBtnImageSearch() {
        mainView.toImageSearch()
    }
}