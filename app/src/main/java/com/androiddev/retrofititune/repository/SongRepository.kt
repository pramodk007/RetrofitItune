package com.androiddev.retrofititune.repository

import com.androiddev.retrofititune.api.RetrofitSingleton
import com.androiddev.retrofititune.data.SearchResultModel
import retrofit2.Response

class SongRepository {

    suspend fun getSong(key:String) : Response<SearchResultModel> {
        return RetrofitSingleton.retrofitService.getSearchResults(key)
    }
}