package com.wujie.kotlinwanandroid

import android.app.Application
import android.content.Context
import com.wujie.kotlinwanandroid.net.RxRetrofit

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 15:37
 *  @Description：
 **/
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        myApplication = this

//        RxRetrofit.get().initRetrofit("")
    }

    companion object {
        private var myApplication: MyApplication? = null

        fun getContext(): Context {
            return myApplication!!
        }
    }

}