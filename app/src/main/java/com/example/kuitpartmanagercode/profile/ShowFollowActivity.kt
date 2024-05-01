package com.example.kuitpartmanagercode.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuitpartmanagercode.databinding.ActivityShowFollowBinding
import com.google.android.material.tabs.TabLayoutMediator

class ShowFollowActivity : AppCompatActivity() {

    lateinit var binding : ActivityShowFollowBinding
    private val tapList = arrayListOf("100 팔로워", "100 팔로잉", "구독")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowFollowBinding.inflate(layoutInflater)

        initView()

        binding.tvFollowerEditName.text = intent.getStringExtra("key")

        binding.ivPrevious.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
    }

    private fun initView() {
        binding.vpFollower.adapter = ShowFollowVPAdapter(this)
        val fragmentIndex = intent.getIntExtra("fragment_index", 0) // 기본값은 0

        TabLayoutMediator(binding.tlFollower, binding.vpFollower){ tab, position ->
            tab.text = tapList[position]
        }.attach()

        binding.vpFollower.setCurrentItem(fragmentIndex, false)
    }
}