package com.ps_ovsyanka.googlesearchapp.ui.di.modules

import android.content.Context
import com.ps_ovsyanka.googlesearchapp.domain.SavedQueryDao
import com.ps_ovsyanka.googlesearchapp.ui.MainActivityPresenter
import com.ps_ovsyanka.googlesearchapp.ui.controllers.homeScreen.HomeScreenPresenter
import com.ps_ovsyanka.googlesearchapp.ui.controllers.search.SearchScreenPresenter
import com.ps_ovsyanka.googlesearchapp.ui.controllers.splash.SplashScreenPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    companion object{
        private val BASE_URL = "https://www.googleapis.com"
    }

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideMainActivityPresenter(): MainActivityPresenter =
        MainActivityPresenter()

    @Provides
    fun provideSearchScreenPresenter(retrofit: Retrofit, dao: SavedQueryDao, context: Context): SearchScreenPresenter =
        SearchScreenPresenter(retrofit, dao, context)

    @Provides
    fun provideHomeScreenPresenter(): HomeScreenPresenter =
        HomeScreenPresenter()

    @Provides
    fun provideSplashScreenPresenter(): SplashScreenPresenter =
        SplashScreenPresenter()

}