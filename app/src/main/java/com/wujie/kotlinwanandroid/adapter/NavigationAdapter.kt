package com.wujie.kotlinwanandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wujie.kotlinwanandroid.R
import com.wujie.kotlinwanandroid.bean.Article
import com.wujie.kotlinwanandroid.bean.Navigation
import com.wujie.kotlinwanandroid.utils.CommonUtils
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import com.zhy.view.flowlayout.TagFlowLayout

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 14:31
 *  @Description：
 **/
class NavigationAdapter() :
    BaseQuickAdapter<Navigation, BaseViewHolder>(R.layout.item_navigation) {


    override fun convert(holder: BaseViewHolder, item: Navigation) {
        holder.setText(R.id.tv_title, item.name)
        var flowLayout: TagFlowLayout = holder.getView(R.id.flow_layout)
        flowLayout.adapter = object : TagAdapter<Article>(item.articles) {
            override fun getView(parent: FlowLayout?, position: Int, t: Article?): View {
                val textView: TextView = LayoutInflater.from(context).inflate(R.layout.tv_flowlayout, flowLayout, false) as TextView
                textView.text = t!!.title
                textView.setTextColor(CommonUtils.randomColor())
                return textView
            }
        }
    }
}