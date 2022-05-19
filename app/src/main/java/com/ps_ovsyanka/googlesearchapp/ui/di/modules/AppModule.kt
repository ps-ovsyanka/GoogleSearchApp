package com.ps_ovsyanka.googlesearchapp.ui.di.modules

import com.ps_ovsyanka.googlesearchapp.ui.MainActivityPresenter
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
    fun provideMainActivityPresenter(retrofit: Retrofit): MainActivityPresenter =
        MainActivityPresenter(retrofit)
}