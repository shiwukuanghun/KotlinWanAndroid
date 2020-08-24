package com.wujie.kotlinwanandroid

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 10:15
 *  @Description：
 **/
open class BasePresenter<V : IBaseView> : IPresenter<V> {

    var mV: V? = null
    var mCompositeDisposable :CompositeDisposable?=null

    override fun attachView(v: V) {
        mV = v
    }

    override fun detachView() {
        mV = null
        removeAllDisposable()
    }

    override fun checkAttachView() {
        if (mV == null) {
            throw RuntimeException("You have not bind this view");
        }
    }

    override fun getView(): V {
        return mV!!
    }

    override fun addDisposable(disposable: Disposable) {
        if (mCompositeDisposable==null) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable!!.add(disposable)
    }

    override fun removeDisposable(disposable: Disposable) {
        if (mCompositeDisposable != null) {
            mCompositeDisposable!!.remove(disposable)
        }
    }

    override fun removeAllDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable!!.clear()
        }
    }
}