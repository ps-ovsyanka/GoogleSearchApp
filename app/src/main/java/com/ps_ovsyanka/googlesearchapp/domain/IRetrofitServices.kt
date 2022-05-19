package com.ps_ovsyanka.googlesearchapp.domain

import com.ps_ovsyanka.googlesearchapp.data.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface IRetrofitServices {

    @GET("/customsearch/v1")
    fun getData(
        @Query("key") key: String?,
        @Query("cx") cx: String?,
        @Query("q") query: String?
    ): Call<ResponseModel>
}