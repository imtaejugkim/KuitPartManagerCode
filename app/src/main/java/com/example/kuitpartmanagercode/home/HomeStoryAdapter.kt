package com.example.kuitpartmanagercode.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuitpartmanagercode.data.HomeStoryData
import com.example.kuitpartmanagercode.databinding.ItemHomeStoryBinding

class HomeStoryAdapter(val items : ArrayList<HomeStoryData>) : RecyclerView.Adapter<HomeStoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHomeStoryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: HomeStoryData){
            binding.tvHomeMyStory.text = data.userId
            binding.sivHomeMyStory.setImageResource(data.storyImage)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeStoryAdapter.ViewHolder {
        val binding = ItemHomeStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeStoryAdapter.ViewHolder, position: Int) {
        return holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}