package com.wujie.kotlinwanandroid.ui.project

import com.wujie.kotlinwanandroid.BasePresenter
import com.wujie.kotlinwanandroid.bean.PageListDataBean
import com.wujie.kotlinwanandroid.bean.Project
import com.wujie.kotlinwanandroid.net.BaseObserver
import com.wujie.kotlinwanandroid.net.RxHelper
import com.wujie.kotlinwanandroid.net.RxRetrofit

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 16:46
 *  @Description：
 **/
class ProjectListPresenter :BasePresenter<ProjectListContact.View>(), ProjectListContact.Presenter {
    override fun getProjectList(cid: Int) {
        addDisposable(RxRetrofit.getApi()
            .getProjectList(cid)
            .compose(RxHelper.rxSchedulerHelper())
            .compose(RxHelper.handleResult2())
            .subscribeWith(object : BaseObserver<PageListDataBean<Project>>(){
                override fun start() {
                }

                override fun onSuccess(t: PageListDataBean<Project>) {
                    mV!!.getProjectListSuccess(t.datas)
                }

                override fun onFailure(code: Int, errorMsg: String) {
                }
            }))

    }

}