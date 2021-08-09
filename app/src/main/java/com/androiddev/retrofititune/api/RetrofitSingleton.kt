package com.androiddev.retrofititune.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton  {

    val BASE_URL = "https://itunes.apple.com/"

    //retrofitObject
    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
    //calling Api
    val retrofitService: SongServiceApi by lazy {
        retrofit().create(SongServiceApi::class.java)
    }

}