package com.wujie.kotlinwanandroid.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wujie.kotlinwanandroid.R
import com.wujie.kotlinwanandroid.bean.Project

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 16:54
 *  @Description：
 **/
class ProjectAdapter : BaseQuickAdapter<Project, BaseViewHolder>(R.layout.item_project) {
    override fun convert(holder: BaseViewHolder, item: Project) {
        holder.setText(R.id.tv_name, item.title + "")
            .setText(R.id.tv_desc, item.desc + "")
            .setText(R.id.tv_time, item.niceDate + "")
            .setText(R.id.tv_author, item.author + "")
    }
}