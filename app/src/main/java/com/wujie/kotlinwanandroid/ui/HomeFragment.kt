package com.wujie.kotlinwanandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wujie.kotlinwanandroid.adapter.HomeAdapter
import com.wujie.kotlinwanandroid.R
import com.wujie.kotlinwanandroid.bean.HomeBean
import com.wujie.kotlinwanandroid.bean.PageListDataBean
import com.wujie.kotlinwanandroid.net.BaseObserver
import com.wujie.kotlinwanandroid.net.RxHelper
import com.wujie.kotlinwanandroid.net.RxRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/22 23:24
 *  @Description：
 **/
class HomeFragment : Fragment() {

    private lateinit var dataList : MutableList<HomeBean>
    private lateinit var mHomeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.rv_home.setHasFixedSize(true)
        view.rv_home.layoutManager = LinearLayoutManager(context)
        dataList = mutableListOf()
        mHomeAdapter = HomeAdapter(dataList)
        view.rv_home.adapter = mHomeAdapter

        loadData()
        return view
    }

    private fun loadData() {
        val subscribeWith = RxRetrofit.getApi()
            .getHomeList(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxHelper.handleResult2())
            .subscribeWith(object : BaseObserver<PageListDataBean<HomeBean>>() {
                override fun start() {
                }

                override fun onSuccess(t: PageListDataBean<HomeBean>) {
                    dataList.addAll(t.datas)
                    mHomeAdapter.notifyDataSetChanged()
                }

                override fun onFailure(code: Int, errorMsg: String) {
                }
            })
    }

}