package com.example.mviexample.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mviexample.R
import com.example.mviexample.databinding.PostItemLayoutBinding
import com.example.mviexample.model.Post

class PostsAdapter(
    private val items: List<Post>,
    private val callback: (id: Int) -> Unit
) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    private lateinit var dataBinding: PostItemLayoutBinding

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        dataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.post_item_layout,
            parent,
            false
        )
        return PostViewHolder(dataBinding.root)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = items[position]
        dataBinding.root.setOnClickListener {
            callback(post.id)
        }
        dataBinding.post = post
    }
}