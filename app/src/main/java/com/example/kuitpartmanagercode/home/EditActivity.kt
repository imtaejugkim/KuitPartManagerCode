package com.example.kuitpartmanagercode.home

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuitpartmanagercode.R
import com.example.kuitpartmanagercode.data.HomePostData
import com.example.kuitpartmanagercode.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("key", HomePostData::class.java)
        } else {
            intent.getSerializableExtra("key") as HomePostData?
        } ?: HomePostData("잘못된 데이터 ", R.drawable.post_gray, R.drawable.post_gray, "잘못된 데이터")

        binding.tvEditName.text = data.InstagramID
        binding.tvEditPostContent.text = data.PostComment
        binding.sivEditProfile.setImageResource(data.ProfileImage)
        binding.ivEditPostImg.setImageResource(data.PostImage)
        
        binding.tvEditCancelBtn.setOnClickListener {
            finish()
        }

    }
}