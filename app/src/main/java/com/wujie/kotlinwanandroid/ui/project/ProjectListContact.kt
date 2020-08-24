package com.wujie.kotlinwanandroid.ui.project

import com.wujie.kotlinwanandroid.IBaseView
import com.wujie.kotlinwanandroid.IPresenter
import com.wujie.kotlinwanandroid.bean.Project

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 16:45
 *  @Description：
 **/
interface ProjectListContact {

    interface View : IBaseView {
        fun getProjectListSuccess(projectList : MutableList<Project>)
    }

    interface Presenter : IPresenter<View> {
        fun getProjectList(cid :Int)
    }

}