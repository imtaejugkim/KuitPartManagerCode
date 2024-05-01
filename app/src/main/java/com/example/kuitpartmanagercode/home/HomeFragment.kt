package com.example.kuitpartmanagercode.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuitpartmanagercode.R
import com.example.kuitpartmanagercode.data.HomePostData
import com.example.kuitpartmanagercode.data.HomeStoryData
import com.example.kuitpartmanagercode.databinding.FragmentHomeBinding
import com.example.kuitpartmanagercode.profile.ProfileFragment


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var postList : ArrayList<HomePostData> = arrayListOf()
    private var storyList : ArrayList<HomeStoryData> = arrayListOf()
    private var homePostAdapter : HomePostAdapter?= null
    private var homeStoryAdapter : HomeStoryAdapter?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //데이터 생성
        initData()
        //RecyclerView 생성
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        homePostAdapter = HomePostAdapter(postList)
        binding.rvPost.adapter = homePostAdapter
        binding.rvPost.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        homeStoryAdapter = HomeStoryAdapter(storyList)
        binding.rvStory.adapter = homeStoryAdapter
        binding.rvStory.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        homePostAdapter!!.setOnItemClickListener(object : HomePostAdapter.OnItemClickListener {

            override fun onNameButtonClick(homePostData: HomePostData) {
                val bundle = Bundle()
                bundle.putSerializable("key", homePostData)

                val profile = ProfileFragment()
                profile.arguments = bundle
                
                //번들로 데이터를 전달하는 다른 방법
                /*val profileFragment = ProfileFragment().apply {
                    arguments = bundleOf("key" to homePostData)
                }*/

                parentFragmentManager.beginTransaction().replace(R.id.main_frm, profile).addToBackStack(null).commit()
            }

            //포스트 옵션 버튼을 눌렀을 때 수정 엑티비티에 String들을 보내고 엑티비티 실행
            override fun onOptionButtonClick(homePostData: HomePostData) {
                val intent = Intent(requireActivity(), EditActivity::class.java)
                //직렬화 객체 전송

                intent.putExtra("key", homePostData)
                startActivity(intent)
            }
        })
    }

    private fun initData() {
        postList.addAll(
            arrayListOf(
                HomePostData("i_m_apple", R.drawable.profile_apple, R.drawable.post_apple, "사과는 맛있어.\n사과는 달아.\n 사과 좋아\n사과 맛없어 맛없어 맛없어 맛없어 맛없어 맛없어"),
                HomePostData("i_m_banana", R.drawable.profile_banana, R.drawable.post_banana, "바나나는 맛있어.\n바나나는 달아.\n사과 좋아\n사과 맛없어 맛없어 맛없어 맛없어 맛없어 맛없어"),
                HomePostData("i_m_pine", R.drawable.profile_pineapple, R.drawable.post_pineapple, "파인애플은 맛있어.\n파인애플는 달아.\n파인애플 좋아\n파인애플 맛없어 맛없어 맛없어 맛없어 맛없어 맛없어"),
                HomePostData("i_am_peach", R.drawable.profile_peach, R.drawable.post_peach, "복숭는 맛있어.\n복숭아는 달아.\n복숭아 좋아\n복숭아 맛없어 맛없어 맛없어 맛없어 맛없어 맛없어"),
                HomePostData("i_am_grape", R.drawable.img_sample, R.drawable.img_sample2, "더보기 버튼 없는 거")
            )
        )

        storyList.addAll(
            arrayListOf(
                HomeStoryData("meo__jung", R.drawable.img_sample),
                HomeStoryData("i_m_apple", R.drawable.profile_apple),
                HomeStoryData("i_m_banana", R.drawable.profile_banana),
                HomeStoryData("i_m_pine", R.drawable.profile_pineapple),
                HomeStoryData("i_m_peach", R.drawable.profile_peach),
                HomeStoryData("i_m_grape", R.drawable.img_sample)
            )
        )

    }
}