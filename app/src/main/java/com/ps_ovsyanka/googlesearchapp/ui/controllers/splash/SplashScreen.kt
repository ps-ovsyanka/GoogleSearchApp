package com.ps_ovsyanka.googlesearchapp.ui.controllers.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.ps_ovsyanka.googlesearchapp.App
import com.ps_ovsyanka.googlesearchapp.R
import com.ps_ovsyanka.googlesearchapp.ui.controllers.search.SearchScreen
import javax.inject.Inject


class SplashScreen: Controller(), ISplashScreenView {

    @Inject
    lateinit var presenter: SplashScreenPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        return  inflater.inflate(R.layout.screen_splash, container, false)
    }

    override fun toRoot(){
        parentController?.router?.popToRoot()
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        App.appComponent.inject(this)
        presenter.onCreate(this)
    }
}