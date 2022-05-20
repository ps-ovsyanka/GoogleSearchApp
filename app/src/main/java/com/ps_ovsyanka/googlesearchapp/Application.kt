package com.ps_ovsyanka.googlesearchapp

import android.app.Application
import com.ps_ovsyanka.googlesearchapp.ui.di.DaggerIApplicationComponent
import com.ps_ovsyanka.googlesearchapp.ui.di.IApplicationComponent
import com.ps_ovsyanka.googlesearchapp.ui.di.modules.ContextModule

class App: Application() {

    companion object{
        lateinit var appComponent: IApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerIApplicationComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

}

