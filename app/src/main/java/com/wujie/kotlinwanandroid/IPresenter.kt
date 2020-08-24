package com.wujie.kotlinwanandroid

import io.reactivex.disposables.Disposable

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 10:15
 *  @Description：
 **/
interface IPresenter<V : IBaseView> {

    fun attachView(v: V)

    fun detachView()

    fun checkAttachView()

    fun getView(): V

    fun addDisposable(disposable: Disposable)

    fun removeDisposable(disposable: Disposable)

    fun removeAllDisposable()

}