package com.example.kuitpartmanagercode.home


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuitpartmanagercode.data.HomePostData
import com.example.kuitpartmanagercode.databinding.ItemHomePostBinding

class HomePostAdapter(val items : ArrayList<HomePostData>) : RecyclerView.Adapter<HomePostAdapter.ViewHolder>(){

    private lateinit var itemClickerListener: OnItemClickListener

    interface OnItemClickListener{
        fun onNameButtonClick(homePostData: HomePostData)
        fun onOptionButtonClick(homePostData: HomePostData)
    }

    inner class ViewHolder(val binding: ItemHomePostBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : HomePostData){
            binding.tvHomePostEdit.text = item.userId
            binding.tvPostInstaId.text = item.userId
            binding.sivHomePost.setImageResource(item.userProfile)
            binding.ivHomePost.setImageResource(item.postImage)
            binding.tvHomeCommentEdit.text = item.postText

            //포스트 옵션 버튼을 눌렀을 때 수정 엑티비티에 String들을 보내고 엑티비티 실행
            binding.ivHomePostOption.setOnClickListener {
                itemClickerListener.onOptionButtonClick(item)
            }

            //포스트의 이름 부분을 눌렀을 때 profile 프래그먼트에 String을 보내고 프래그먼트의 화면으로 교체
            binding.tvHomePostEdit.setOnClickListener {
                itemClickerListener.onNameButtonClick(item)
            }

            if (binding.tvHomeCommentEdit.length() < 26)
            {
                binding.tvPostCommentPlus.visibility = View.GONE
            } else {
                //포스트 댓글의 더보기 버튼을 눌렀을 때 댓글의 나머지 부분 표시
                binding.tvPostCommentPlus.setOnClickListener {
                    binding.tvPostCommentPlus.visibility = View.GONE
                    binding.tvHomeCommentEdit.ellipsize = null
                    binding.tvHomeCommentEdit.maxLines = Int.MAX_VALUE
                }
            }
        }
    }

    //setter?
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        itemClickerListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomePostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}