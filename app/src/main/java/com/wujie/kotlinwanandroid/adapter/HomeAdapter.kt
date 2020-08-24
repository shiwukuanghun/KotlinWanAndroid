package com.wujie.kotlinwanandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wujie.kotlinwanandroid.R
import com.wujie.kotlinwanandroid.bean.HomeBean

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 18:34
 *  @Description：
 **/
class HomeAdapter(var dataList: MutableList<HomeBean>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return HomeHolder(view)
    }

    override fun getItemCount(): Int {
        return if (dataList == null) 0 else dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val homeHolder : HomeHolder = holder as HomeHolder
        val homeBean = dataList[position]
        homeHolder.tvAuthor.text = "" + homeBean.author
        homeHolder.tvTitle.text = homeBean.title
        homeHolder.tvType.text = homeBean.chapterName
    }

    inner class HomeHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvAuthor = view.findViewById<TextView>(R.id.tv_author)
        var tvTitle = view.findViewById<TextView>(R.id.tv_title)
        var tvType = view.findViewById<TextView>(R.id.tv_type)
    }

}