package com.wujie.kotlinwanandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wujie.kotlinwanandroid.BasePresenter
import com.wujie.kotlinwanandroid.IBaseView

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 10:11
 *  @Description：
 **/
abstract class BaseFragment<P : BasePresenter<V>, V : IBaseView> : Fragment(), IBaseView {

    private lateinit var mView: View
    protected lateinit var mPresenter: P

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(getLayoutId(), container, false)
        mPresenter = createPresenter()
        attachView()
        init(mView)
        return mView
    }

    abstract fun getLayoutId(): Int

    abstract fun init(view: View)

    abstract fun createPresenter(): P

    private fun attachView() {
        mPresenter.attachView(this as V)
    }

    private fun detachView() {
        mPresenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        detachView()
    }

    override fun showLoading(msg: String) {
    }

    override fun hideLoading() {
    }

    override fun showError() {
    }

    override fun showFailure(msg: String) {
    }

    override fun showEmpty() {
    }

}