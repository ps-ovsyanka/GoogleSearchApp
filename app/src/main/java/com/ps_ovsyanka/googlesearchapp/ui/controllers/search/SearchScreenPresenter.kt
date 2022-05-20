package com.ps_ovsyanka.googlesearchapp.ui.controllers.search

import com.ps_ovsyanka.googlesearchapp.data.Item
import com.ps_ovsyanka.googlesearchapp.data.ResponseModel
import com.ps_ovsyanka.googlesearchapp.data.SavedQuery
import com.ps_ovsyanka.googlesearchapp.domain.IRetrofitServices
import com.ps_ovsyanka.googlesearchapp.domain.SavedQueryDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import java.util.*

class SearchScreenPresenter(
    private val retrofit: Retrofit,
    private val dao: SavedQueryDao
    ): Callback<ResponseModel> {

    companion object{
        private const val API_KEY = "AIzaSyAq9xyzCZlcQFmCgKm633EZp1AFbmYYWfQ"
        private const val CX = "8b8faaa29e4af41f0"
    }

    private lateinit var view: ISearchSreenView
    private val api = retrofit.create(IRetrofitServices::class.java)
    private val coroutineIO = CoroutineScope(Dispatchers.Main)

    fun onCreate(mainView: SearchScreen){
        view = mainView
    }

    fun search(query: String) {
        view.showLoader()
        api.getData(API_KEY, CX, query).enqueue(this)
    }

    private fun updateResponseList(items: List<Item?>){
        view.updateList(items)
    }

    override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
        view.hideLoader()

        if (response.isSuccessful){
            response.body()?.items?.let { updateResponseList(it) }
            saveQuery(response.body()?.queries?.request?.first()?.searchTerms.toString())
        } else {
            view.showMessage("Код ошибки: "+response.code().toString())
        }
    }

    override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
        view.hideLoader()
        view.showMessage(t.localizedMessage)
    }

    private fun saveQuery(query: String) {
        coroutineIO.launch {
            dao.insert(SavedQuery(query = query, date = Date().toString()))
        }
    }

    fun inputTextFocus(){
        coroutineIO.launch {
            view.showSavedQueries(dao.getStringQuery())
        }
    }
}