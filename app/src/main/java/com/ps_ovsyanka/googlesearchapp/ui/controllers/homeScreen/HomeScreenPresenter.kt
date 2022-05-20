package com.ps_ovsyanka.googlesearchapp.ui.controllers.homeScreen

class HomeScreenPresenter {

    lateinit var mainView: IHomeScreenView

    fun onCreate(view: IHomeScreenView){
        mainView = view
        view.toSearchScreen()
    }
}