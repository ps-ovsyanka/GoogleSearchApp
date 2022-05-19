package com.ps_ovsyanka.googlesearchapp.ui

import com.ps_ovsyanka.googlesearchapp.data.Item

interface IMainActivityView {
    fun updateList(items: List<Item?>)
}