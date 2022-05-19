package com.ps_ovsyanka.googlesearchapp.ui.di

import com.ps_ovsyanka.googlesearchapp.ui.MainActivity
import com.ps_ovsyanka.googlesearchapp.ui.di.modules.AppModule
import dagger.Component


@Component(modules = [AppModule::class])
interface IApplicationComponent {
    fun inject(mainActivity: MainActivity?)
}