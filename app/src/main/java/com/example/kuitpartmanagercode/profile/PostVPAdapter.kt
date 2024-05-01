package com.example.kuitpartmanagercode.profile

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PostVPAdapter (fragment: Fragment) : FragmentStateAdapter(fragment){
    private var imageClickListener: PostFragment.OnImageClickListener? = null

    fun setOnImageClickListener(listener: PostFragment.OnImageClickListener) {
        imageClickListener = listener
    }

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> PostFragment().also { it.listener = imageClickListener }
            else -> TagFragment()
        }
    }
}