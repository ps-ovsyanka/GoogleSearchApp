package com.ps_ovsyanka.googlesearchapp.ui.controllers.homeScreen

import kotlinx.coroutines.*

class HomeScreenPresenter {

    lateinit var mainView: IHomeScreenView

    fun onCreate(view: IHomeScreenView){
        mainView = view
        view.toSplashScreen()
        val coroutine = CoroutineScope(Dispatchers.IO)
        coroutine.launch() {
            delay(5000)
            withContext(Dispatchers.Main) {
                view.toRoot()
                view.toSearchScreen()
            }
        }
    }
}