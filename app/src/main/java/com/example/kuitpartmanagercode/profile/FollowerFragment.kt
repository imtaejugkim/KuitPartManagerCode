package com.example.kuitpartmanagercode.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuitpartmanagercode.data.FollowerData
import com.example.kuitpartmanagercode.R
import com.example.kuitpartmanagercode.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {

    lateinit var binding : FragmentFollowerBinding
    private var itemList : ArrayList<FollowerData> = arrayListOf()
    private var followerAdapter : FollowerAdapter?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFollowerBinding.inflate(inflater, container, false)

        initRecyclerView()
        initData()

        return binding.root
    }

    private fun initRecyclerView() {
        followerAdapter = FollowerAdapter(itemList)
        binding.rvFollower.adapter = followerAdapter
        binding.rvFollower.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
    }

    private fun initData() {
        itemList.addAll(
            arrayListOf(
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린"),
                FollowerData(R.drawable.img_sample, "ri._.nny", "김채린")
            )
        )
    }

}