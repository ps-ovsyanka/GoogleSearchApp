package com.ps_ovsyanka.googlesearchapp.ui.di

import com.ps_ovsyanka.googlesearchapp.ui.MainActivity
import com.ps_ovsyanka.googlesearchapp.ui.controllers.homeScreen.HomeScreen
import com.ps_ovsyanka.googlesearchapp.ui.controllers.search.SearchScreen
import com.ps_ovsyanka.googlesearchapp.ui.controllers.splash.SplashScreen
import com.ps_ovsyanka.googlesearchapp.ui.di.modules.AppModule
import com.ps_ovsyanka.googlesearchapp.ui.di.modules.ContextModule
import com.ps_ovsyanka.googlesearchapp.ui.di.modules.DatabaseModule
import dagger.Component


@Component(modules = [ContextModule::class, AppModule::class, DatabaseModule::class])
interface IApplicationComponent {
    fun inject(mainActivity: MainActivity?)
    fun inject(searchScreen: SearchScreen?)
    fun inject(homeScreen: HomeScreen?)
    fun inject(splashScreen: SplashScreen?)
}