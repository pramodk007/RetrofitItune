package com.androiddev.retrofititune.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResultModel (
    @SerializedName("artistName")
    @Expose
    val artistName: String,

    @SerializedName("trackName")
    @Expose
    val trackName: String,

    @SerializedName("previewUrl")
    @Expose
    val previewUrl: String,

    @SerializedName("artworkUrl100")
    @Expose
    val artworkUrl100: String
)