package com.wujie.kotlinwanandroid.ui.navigation

import com.wujie.kotlinwanandroid.IBaseView
import com.wujie.kotlinwanandroid.IPresenter
import com.wujie.kotlinwanandroid.bean.Navigation

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 14:09
 *  @Description：
 **/
interface NavigationContact {

    interface View : IBaseView {
        fun getNavigationSuccess(navigationList : MutableList<Navigation>)
    }

    interface Presenter : IPresenter<View> {
        fun getNavigation()
    }

}