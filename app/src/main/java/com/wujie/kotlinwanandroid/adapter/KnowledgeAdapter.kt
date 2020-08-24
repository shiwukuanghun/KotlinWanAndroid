package com.wujie.kotlinwanandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wujie.kotlinwanandroid.R
import com.wujie.kotlinwanandroid.bean.ProjectType

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 13:27
 *  @Description：
 **/
class KnowledgeAdapter(var dataList: MutableList<ProjectType>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_knowledge, parent, false)
        return KnowledgeHolder(view)
    }

    override fun getItemCount(): Int {
        return if (dataList == null) 0 else dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var knowledgeHolder : KnowledgeHolder = holder as KnowledgeHolder
        val projectType = dataList[position]
        knowledgeHolder.tvTitle.text = projectType.name
        var desc = ""
        projectType.children.forEach { desc = "${it.name}   $desc" }
        knowledgeHolder.tvDesc.text = desc
    }

    inner class KnowledgeHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle = view.findViewById<TextView>(R.id.tv_title)
        var tvDesc = view.findViewById<TextView>(R.id.tv_desc)
    }
}