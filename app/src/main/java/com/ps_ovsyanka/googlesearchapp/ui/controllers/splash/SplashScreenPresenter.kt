package com.ps_ovsyanka.googlesearchapp.ui.controllers.splash

import kotlinx.coroutines.*


class SplashScreenPresenter {
    lateinit var mainView: ISplashScreenView

    fun onCreate(view: ISplashScreenView){
        mainView = view
        val coroutine = CoroutineScope(Dispatchers.IO)
        coroutine.launch() {
            delay(3000)
            withContext(Dispatchers.Main) {
                mainView.endLoaded()
            }
        }
    }
}