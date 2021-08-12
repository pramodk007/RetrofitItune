package com.androiddev.retrofititune.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddev.retrofititune.adapter.SongAdapter
import com.androiddev.retrofititune.data.ResultModel
import com.androiddev.retrofititune.databinding.ActivityMainBinding
import com.androiddev.retrofititune.repository.SongRepository
import com.androiddev.retrofititune.viewModel.MainViewModel
import com.androiddev.retrofititune.viewModel.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel :MainViewModel
    lateinit var binding:ActivityMainBinding
    var search:String = ""
    lateinit var songAdapter: SongAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        songAdapter = SongAdapter()
        binding.rvSongsList.setAdapter(songAdapter)
        binding.rvSongsList.layoutManager = LinearLayoutManager(this@MainActivity)


        val repository= SongRepository()

        val mainViewFactory= MainViewModelFactory(repository)
        mainViewModel= ViewModelProvider(this,mainViewFactory).get(MainViewModel::class.java)

        binding.btnSearch.setOnClickListener{
            getSongs();
        }
    }

    private fun getSongs() {
        search = binding.edtSearchSong.text.toString()
        if (search.isEmpty()) {
            Toast.makeText(applicationContext, "enter the query to search.", Toast.LENGTH_SHORT)
                .show()
        }
        val ch = '+'
        search = search.replace(' ', ch)
        mainViewModel.getSong(search)
        mainViewModel.mResponse.observe(this, Observer {
                response->
            if(response.isSuccessful) {
                val resultModelList: List<ResultModel> = response.body()!!.resultModels
                if (resultModelList.isNotEmpty()) {
                    songAdapter.submitList(resultModelList)
                }
            }
            else{
                Log.d("error","cant get query")
            }

        })
    }

}
