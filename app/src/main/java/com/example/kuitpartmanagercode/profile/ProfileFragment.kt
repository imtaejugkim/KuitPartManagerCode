package com.example.kuitpartmanagercode.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kuitpartmanagercode.R
import com.example.kuitpartmanagercode.data.HomePostData
import com.example.kuitpartmanagercode.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private val tabIcons = arrayListOf(R.drawable.grid, R.drawable.tag)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        
        val bundle = arguments
        if (bundle != null && bundle.containsKey("key")) {
            val homePostData = bundle.getSerializable("key") as HomePostData

            binding.tvEditProfileName.text = homePostData.InstagramID
            binding.sivProfileEdit.setImageResource(homePostData.ProfileImage)
        }

        initView()
        initFollowerFollowing()

        return binding.root
    }

    private fun initFollowerFollowing() {
        binding.tvFollower.setOnClickListener {
            val intent = Intent(requireActivity(), ShowFollowActivity::class.java)
            intent.putExtra("key", binding.tvEditProfileName.text)
            intent.putExtra("fragment_index", 0) // 첫 번째 fragment를 보여주기 위한 index
            startActivity(intent)
        }

        binding.tvFollowing.setOnClickListener {
            val intent = Intent(requireActivity(), ShowFollowActivity::class.java)
            intent.putExtra("key", binding.tvEditProfileName.text)
            intent.putExtra("fragment_index", 1) // 두 번째 fragment를 보여주기 위한 index
            startActivity(intent)
        }
    }

    private fun initView() {
        binding.vpProfile.adapter = PostVPAdapter(this).apply {
            setOnImageClickListener(object : PostFragment.OnImageClickListener {
                override fun onImageClick() {
                    val detailFragment = PostDetailFragment()
                    parentFragmentManager.beginTransaction().apply {
                        replace(R.id.main_frm, detailFragment)
                        addToBackStack(null)
                        commit()
                    }
                }
            })
        }

        TabLayoutMediator(binding.tlProfile, binding.vpProfile){ tab, position ->
            tab.setIcon(tabIcons[position])
        }.attach()
    }

}