package com.wujie.kotlinwanandroid.ui.navigation

import com.wujie.kotlinwanandroid.BasePresenter
import com.wujie.kotlinwanandroid.bean.Navigation
import com.wujie.kotlinwanandroid.net.BaseObserver
import com.wujie.kotlinwanandroid.net.RxHelper
import com.wujie.kotlinwanandroid.net.RxRetrofit

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 14:10
 *  @Description：
 **/
class NavigationPresenter : BasePresenter<NavigationContact.View>(), NavigationContact.Presenter {
    override fun getNavigation() {
        addDisposable(RxRetrofit.getApi()
            .getNavigation()
            .compose(RxHelper.rxSchedulerHelper())
            .compose(RxHelper.handleResult2())
            .subscribeWith(object  : BaseObserver<MutableList<Navigation>>(){
                override fun start() {
                }

                override fun onSuccess(t: MutableList<Navigation>) {
                    mV!!.getNavigationSuccess(t)
                }

                override fun onFailure(code: Int, errorMsg: String) {
                }
            }))

    }
}