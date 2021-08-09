package com.androiddev.retrofititune.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.retrofititune.data.SearchResultModel
import com.androiddev.retrofititune.repository.SongRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: SongRepository) : ViewModel() {
    val mResponse : MutableLiveData<Response<SearchResultModel>> = MutableLiveData()

    fun getSong(key:String){
        viewModelScope.launch {
            try {
                val response = repository.getSong(key)

                mResponse.value = response
            }
            catch(e: Exception){
                Log.d("error message",e.toString())
            }
        }
    }


}