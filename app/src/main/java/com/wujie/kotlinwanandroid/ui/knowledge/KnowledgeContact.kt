package com.wujie.kotlinwanandroid.ui.knowledge

import com.wujie.kotlinwanandroid.IBaseView
import com.wujie.kotlinwanandroid.IPresenter
import com.wujie.kotlinwanandroid.bean.ProjectType

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 10:37
 *  @Description：
 **/
interface KnowledgeContact {

    interface View : IBaseView {
        fun getKnowledgeSuccess(projectTypeList: MutableList<ProjectType>)
    }

    interface Presenter : IPresenter<View> {
        fun getKnowledge()
    }

}