package com.example.kuitpartmanagercode.data

import java.io.Serializable


data class HomePostData(
    val InstagramID: String,
    val ProfileImage: Int,
    val PostImage: Int,
    val PostComment: String
) : Serializable


