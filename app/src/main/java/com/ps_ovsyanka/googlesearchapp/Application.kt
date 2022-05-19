package com.ps_ovsyanka.googlesearchapp

import android.app.Application
import com.ps_ovsyanka.googlesearchapp.ui.di.DaggerIApplicationComponent
import com.ps_ovsyanka.googlesearchapp.ui.di.IApplicationComponent

class App: Application() {

    companion object{
        lateinit var appComponent: IApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerIApplicationComponent
            .builder()
            .build()
    }

}

