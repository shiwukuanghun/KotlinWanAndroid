package com.wujie.kotlinwanandroid.ui.project

import com.wujie.kotlinwanandroid.BasePresenter
import com.wujie.kotlinwanandroid.bean.ProjectType
import com.wujie.kotlinwanandroid.net.BaseObserver
import com.wujie.kotlinwanandroid.net.RxHelper
import com.wujie.kotlinwanandroid.net.RxRetrofit

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 16:23
 *  @Description：
 **/
class ProjectPresenter : BasePresenter<ProjectContact.View>(), ProjectContact.Presenter {
    override fun getProjectType() {
        addDisposable(RxRetrofit.getApi()
            .getProjectType()
            .compose(RxHelper.rxSchedulerHelper())
            .compose(RxHelper.handleResult2())
            .subscribeWith(object : BaseObserver<MutableList<ProjectType>>() {
                override fun start() {
                }

                override fun onSuccess(t: MutableList<ProjectType>) {
                    mV!!.getProjectTypeSuccess(t)
                }

                override fun onFailure(code: Int, errorMsg: String) {
                }
            }))

    }
}