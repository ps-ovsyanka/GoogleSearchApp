package com.ps_ovsyanka.googlesearchapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor.attachRouter
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.ps_ovsyanka.googlesearchapp.App
import com.ps_ovsyanka.googlesearchapp.R
import com.ps_ovsyanka.googlesearchapp.ui.controllers.homeScreen.HomeScreen
import com.ps_ovsyanka.googlesearchapp.ui.controllers.splash.SplashScreen
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), IMainActivityView {

    @Inject
    lateinit var presenter: MainActivityPresenter
    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
        presenter.onCreate(this)


        router = attachRouter(this, container, savedInstanceState)
            .setPopRootControllerMode(Router.PopRootControllerMode.POP_ROOT_CONTROLLER_BUT_NOT_VIEW)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(HomeScreen()))
        }
        router.pushController(RouterTransaction.with(SplashScreen()))
    }

    override fun toHome(){
        router.popToRoot()
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

}