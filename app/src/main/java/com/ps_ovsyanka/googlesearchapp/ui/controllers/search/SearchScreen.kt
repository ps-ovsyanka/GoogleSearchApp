package com.ps_ovsyanka.googlesearchapp.ui.controllers.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bluelinelabs.conductor.Controller
import com.ps_ovsyanka.googlesearchapp.App
import com.ps_ovsyanka.googlesearchapp.R
import com.ps_ovsyanka.googlesearchapp.data.Item
import com.ps_ovsyanka.googlesearchapp.ui.adapter.ResponseAdapter
import com.ps_ovsyanka.googlesearchapp.ui.adapter.SavedQueriesAdapter
import kotlinx.android.synthetic.main.screen_search.view.*
import javax.inject.Inject

class SearchScreen: Controller(), ISearchSreenView {

    @Inject
    lateinit var presenter: SearchScreenPresenter
    private val responseAdapter = ResponseAdapter()
    private val queriesAdapter = SavedQueriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        App.appComponent.inject(this)
        val view = inflater.inflate(R.layout.screen_search, container, false)
        view.apply {
            responseList.adapter = responseAdapter
            savedQueries.adapter = queriesAdapter
            queriesAdapter.listener =  {
                inputSearchText.setText(it)
            }
            buttonSearch.setOnClickListener {
                presenter.search(inputSearchText.text.toString())
            }
            inputSearchText.setOnFocusChangeListener { v: View?, hasFocus: Boolean ->
                if (hasFocus) presenter.inputTextFocus()
                else hideSavedQueries()
            }

        }
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        App.appComponent.inject(this)
        presenter.onCreate(this)
    }

    override fun updateList(items: List<Item?>) {
        responseAdapter.refresh(items as List<Item>)
    }

    override fun showLoader(){
        responseAdapter.clear()
        view?.messageView?.visibility = TextView.GONE
        view?.loader?.visibility = ProgressBar.VISIBLE
        view?.clearFocus()
    }

    override fun hideLoader(){
        view?.loader?.visibility = ProgressBar.GONE
    }

    override fun showMessage(message: String){
        view!!.messageView!!.text = message
        view?.messageView?.visibility = TextView.VISIBLE
    }

    override fun showSavedQueries(list: List<String>) {
        queriesAdapter.refresh(list)
        view?.savedQueries?.visibility = RecyclerView.VISIBLE
    }

    override fun hideSavedQueries() {
        view?.savedQueries?.visibility = RecyclerView.GONE
    }
}