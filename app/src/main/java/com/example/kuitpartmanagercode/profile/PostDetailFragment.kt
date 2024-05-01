package com.example.kuitpartmanagercode.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kuitpartmanagercode.databinding.FragmentPostDetailBinding

class PostDetailFragment : Fragment() {
    lateinit var binding : FragmentPostDetailBinding
    private val imgList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostDetailBinding.inflate(layoutInflater)

        initDummyData()
        initViewPager()

        return binding.root
    }

    private fun initViewPager() {
        binding.vpPostDetail.adapter = PostDetailAdapter(requireContext(), imgList)
        binding.vpPostDetail.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.wormDotsIndicator.attachTo(binding.vpPostDetail)
    }

    private fun initDummyData() {
        imgList.add("https://cdn.pixabay.com/photo/2017/09/25/13/12/puppy-2785074_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2017/10/16/19/57/cat-2858293_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2016/03/27/18/10/bear-1283347_1280.jpg")
    }

}