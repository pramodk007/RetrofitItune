package com.androiddev.retrofititune.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResultModel (

    @SerializedName("resultCount")
    @Expose
    val resultCount:Int,

    @SerializedName("results")
    @Expose
    val resultModels: List<ResultModel>
)
