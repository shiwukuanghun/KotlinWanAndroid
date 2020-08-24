package com.wujie.kotlinwanandroid

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 10:13
 *  @Description：
 **/
interface IBaseView {

    fun showLoading(msg: String)

    fun hideLoading()

    fun showError()

    fun showFailure(msg: String)

    fun showEmpty()

}