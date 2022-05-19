package com.ps_ovsyanka.googlesearchapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ps_ovsyanka.googlesearchapp.App
import com.ps_ovsyanka.googlesearchapp.R
import com.ps_ovsyanka.googlesearchapp.data.Item
import com.ps_ovsyanka.googlesearchapp.ui.adapter.ResponseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainActivityView {

    @Inject
    lateinit var presenter: MainActivityPresenter
    val adapter = ResponseAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
        presenter.onCreate(this)

        responseList.adapter = adapter
        buttonSearch.setOnClickListener(View.OnClickListener {
            presenter.search(inputSearchText.text.toString())
        })
    }

    override fun updateList(items: List<Item?>) {
        adapter.refresh(items as List<Item>)
    }
}