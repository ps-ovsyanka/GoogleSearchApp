package com.ps_ovsyanka.googlesearchapp.data

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Queries {
    @SerializedName("request")
    @Expose
    var request: List<Request>? = null
}