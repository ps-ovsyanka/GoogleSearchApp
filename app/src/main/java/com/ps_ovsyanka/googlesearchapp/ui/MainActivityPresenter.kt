package com.ps_ovsyanka.googlesearchapp.ui

import android.util.Log
import com.ps_ovsyanka.googlesearchapp.data.Item
import com.ps_ovsyanka.googlesearchapp.data.ResponseModel
import com.ps_ovsyanka.googlesearchapp.domain.IRetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivityPresenter(retrofit: Retrofit): Callback<ResponseModel> {

    companion object{
        private val API_KEY = "AIzaSyAq9xyzCZlcQFmCgKm633EZp1AFbmYYWfQ"
        private val CX = "8b8faaa29e4af41f0"
    }

    private lateinit var view: IMainActivityView
    private val api = retrofit.create(IRetrofitServices::class.java)

    fun onCreate(mainView: MainActivity){
        view = mainView
    }

    fun search(query: String) {
        api.getData(API_KEY, CX, query).enqueue(this)
    }

    fun updateResponseList(items: List<Item?>){
        view.updateList(items)
    }

    override fun onResponse(
        call: Call<ResponseModel>,
        response: Response<ResponseModel>
    ) {
        response.body()?.items?.let { updateResponseList(it) }
    }

    override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
        Log.e("TAG", t.getLocalizedMessage());
    }


}