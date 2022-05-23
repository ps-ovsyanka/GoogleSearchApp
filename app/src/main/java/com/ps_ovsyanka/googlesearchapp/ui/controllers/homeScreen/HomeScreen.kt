package com.ps_ovsyanka.googlesearchapp.ui.controllers.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.ps_ovsyanka.googlesearchapp.App
import com.ps_ovsyanka.googlesearchapp.R
import com.ps_ovsyanka.googlesearchapp.ui.controllers.search.SearchScreen
import com.ps_ovsyanka.googlesearchapp.ui.controllers.splash.SplashScreen
import kotlinx.android.synthetic.main.screen_home.*
import kotlinx.android.synthetic.main.screen_home.view.*
import javax.inject.Inject

class HomeScreen: Controller(), IHomeScreenView {

    @Inject
    lateinit var presenter: HomeScreenPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {

        return inflater.inflate(R.layout.screen_home, container, false)
    }

    override fun toRoot(){
        router.popToRoot()
    }

    override fun toSplashScreen(){
        getChildRouter(view!!.home_container)
            .setRoot(RouterTransaction.with(SplashScreen()))
    }

    override fun toSearchScreen(){
        getChildRouter(view!!.home_container)
            .setRoot(RouterTransaction.with(SearchScreen()))
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        App.appComponent.inject(this)
        presenter.onCreate(this)
    }

}