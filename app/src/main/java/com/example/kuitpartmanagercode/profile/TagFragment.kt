package com.example.kuitpartmanagercode.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kuitpartmanagercode.databinding.FragmentTagedPostBinding

class TagFragment : Fragment() {

    lateinit var binding : FragmentTagedPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTagedPostBinding.inflate(inflater, container, false)

        initTaggedPostPicture()

        return binding.root
    }

    private fun initTaggedPostPicture() {
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2019/08/07/14/11/dog-4390885_1280.jpg")
            .into(binding.ivTaggedPost1)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2016/01/05/17/51/maltese-1123016_1280.jpg")
            .into(binding.ivTaggedPost2)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2020/05/03/13/09/puppy-5124947_1280.jpg")
            .into(binding.ivTaggedPost3)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2019/05/27/12/04/welsh-corgi-pembroke-4232496_1280.jpg")
            .into(binding.ivTaggedPost4)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2017/11/01/17/42/dog-and-cat-2908810_1280.jpg")
            .into(binding.ivTaggedPost5)
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2015/05/20/10/03/cat-and-dog-775116_1280.jpg")
            .into(binding.ivTaggedPost6)

    }

}