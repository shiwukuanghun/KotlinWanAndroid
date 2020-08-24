package com.wujie.kotlinwanandroid.ui.knowledge

import com.wujie.kotlinwanandroid.BasePresenter
import com.wujie.kotlinwanandroid.bean.Knowledge
import com.wujie.kotlinwanandroid.net.BaseObserver
import com.wujie.kotlinwanandroid.net.RxHelper
import com.wujie.kotlinwanandroid.net.RxRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 13:10
 *  @Description：
 **/
class KnowledgePresenter : BasePresenter<KnowledgeContact.View>(),KnowledgeContact.Presenter {
    override fun getKnowledge() {
        addDisposable(RxRetrofit.getApi()
            .getKnowledge()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxHelper.handleResult2())
            .subscribeWith(object :BaseObserver<MutableList<Knowledge>>(){
                override fun start() {
                }

                override fun onSuccess(t: MutableList<Knowledge>) {
                    mV!!.getKnowledgeSuccess(t)
                }

                override fun onFailure(code: Int, errorMsg: String) {
                }
            }))

    }
}