package com.wujie.kotlinwanandroid.ui.knowledge

import com.wujie.kotlinwanandroid.IBaseView
import com.wujie.kotlinwanandroid.IPresenter
import com.wujie.kotlinwanandroid.bean.Knowledge

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 10:37
 *  @Description：
 **/
interface KnowledgeContact {

    interface View : IBaseView {
        fun getKnowledgeSuccess(knowledgeList: MutableList<Knowledge>)
    }

    interface Presenter : IPresenter<View> {
        fun getKnowledge()
    }

}