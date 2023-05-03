package com.example.dailypaper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.dailypaper.R
import com.example.dailypaper.model.SurfaceNews

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/5/2 15:01
 */
class NewsAdapter(private val fragment: Fragment, private val data: List<SurfaceNews.News>) :
    RecyclerView.Adapter<NewsAdapter.Holder>() {
    class Holder(root: View) : ViewHolder(root){
        val newsTitle = root.findViewById<TextView>(R.id.title)
        val newsHint = root.findViewById<TextView>(R.id.hint)
        val newsImage = root.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //拿到LayoutInflater
        val inflater = LayoutInflater.from(parent.context)
        //inflate item布局
        val view = inflater.inflate(R.layout.news_item,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val itemData = data[position]
        holder.apply { newsTitle.text = itemData.title
        newsHint.text = itemData.hint
        }
        Glide.with(fragment).load(itemData.images).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}