package com.example.dailypaper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dailypaper.R
import com.example.dailypaper.model.TopNews

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/5/2 17:04
 */
class TopNewsAdapter(private val fragment: Fragment,private val data: List<TopNews>):RecyclerView.Adapter<TopNewsAdapter.Holder>() {
    class Holder(root:View):RecyclerView.ViewHolder(root){
        val topNewsImage: ImageView = root.findViewById(R.id.topnews_image)
        val topNewsTitle: TextView = root.findViewById(R.id.topnews_title)
        val topNewsHint: TextView = root.findViewById(R.id.topnews_hint)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //拿到LayoutInflater
        val inflater = LayoutInflater.from(parent.context)
        //inflate item布局
        val view = inflater.inflate(R.layout.topnews_item,parent,false)
        return TopNewsAdapter.Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val itemData = data[position]
        holder.apply { topNewsTitle.text = itemData.title
            topNewsHint.text = itemData.hint
        }
        Glide.with(fragment).load(itemData.image).into(holder.topNewsImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}