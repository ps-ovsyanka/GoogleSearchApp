package com.ps_ovsyanka.googlesearchapp.ui.controllers.search

import com.ps_ovsyanka.googlesearchapp.data.Item

interface ISearchSreenView {
    fun updateList(items: List<Item?>)
    fun showLoader()
    fun hideLoader()
    fun showMessage(message: String)
    fun showSavedQueries(list: List<String>)
    fun hideSavedQueries()
}