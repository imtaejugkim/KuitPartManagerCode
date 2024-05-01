package com.example.kuitpartmanagercode.reels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kuitpartmanagercode.databinding.FragmentReelsBinding

class ReelsFragment : Fragment() {
    lateinit var binding: FragmentReelsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}