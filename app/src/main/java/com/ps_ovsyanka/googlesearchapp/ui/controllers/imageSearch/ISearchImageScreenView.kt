package com.ps_ovsyanka.googlesearchapp.ui.controllers.imageSearch

import com.ps_ovsyanka.googlesearchapp.data.Item

interface ISearchImageScreenView {
    fun updateList(items: List<Item?>)
    fun showLoader()
    fun hideLoader()
    fun showMessage(message: String)
    fun showSavedQueries(list: List<String>)
    fun hideSavedQueries()
}