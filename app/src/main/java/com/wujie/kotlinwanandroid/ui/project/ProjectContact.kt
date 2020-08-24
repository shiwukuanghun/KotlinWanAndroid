package com.wujie.kotlinwanandroid.ui.project

import com.wujie.kotlinwanandroid.IBaseView
import com.wujie.kotlinwanandroid.IPresenter
import com.wujie.kotlinwanandroid.bean.ProjectType

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 16:22
 *  @Description：
 **/
interface ProjectContact {

    interface View : IBaseView {
        fun getProjectTypeSuccess(projectTypeList: MutableList<ProjectType>)
    }

    interface Presenter : IPresenter<View> {
        fun getProjectType()
    }

}