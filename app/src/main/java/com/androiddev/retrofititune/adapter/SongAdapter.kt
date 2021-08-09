package com.androiddev.retrofititune.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.androiddev.retrofititune.data.ResultModel
import com.androiddev.retrofititune.databinding.SongSingleRowBinding
import com.bumptech.glide.Glide

class SongAdapter: ListAdapter<ResultModel, SongAdapter.SongsViewHolder>(SongsComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val binding = SongSingleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class SongsViewHolder(private val binding: SongSingleRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: ResultModel) {
            binding.apply {
                Glide.with(itemView)
                    .load(result.artworkUrl100)
                    .into(imgPic)
                textViewHead.text = result.trackName
                textViewDesc.text = result.artistName
            }
        }
    }

    class SongsComparator : DiffUtil.ItemCallback<ResultModel>() {
        override fun areItemsTheSame(oldItem: ResultModel, newItem: ResultModel) =
            oldItem.trackName == newItem.trackName


        override fun areContentsTheSame(oldItem: ResultModel, newItem: ResultModel) =
            oldItem == newItem

    }
}