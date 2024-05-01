package com.example.kuitpartmanagercode.data

import java.io.Serializable


data class HomePostData(
    val userId: String,
    val userProfile: Int,
    val postImage: Int,
    val postText: String
) : Serializable


