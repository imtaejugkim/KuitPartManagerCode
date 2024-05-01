package com.example.kuitpartmanagercode.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kuitpartmanagercode.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    var listener : OnImageClickListener?= null
    lateinit var binding : FragmentPostBinding

    interface OnImageClickListener{
        fun onImageClick()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(inflater, container, false)

        initPostPicture()

        return binding.root
    }

    private fun initPostPicture() {
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2021/09/28/13/14/cat-6664412_1280.jpg")
            .into(binding.ivPost1)

        binding.ivPost1.setOnClickListener {
            listener?.onImageClick()
        }
    }

}