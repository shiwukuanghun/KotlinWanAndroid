package com.wujie.kotlinwanandroid.net

import android.text.TextUtils
import android.widget.Toast
import com.wujie.kotlinwanandroid.MyApplication
import com.wujie.kotlinwanandroid.bean.BaseBean
import io.reactivex.observers.ResourceObserver
import retrofit2.HttpException

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 14:32
 *  @Description：
 **/
abstract class BaseObserver<T> : ResourceObserver<T>() {

    private var errorMsg: String? = null

    override fun onStart() {
        super.onStart()
        start()
    }

    override fun onComplete() {

    }

    override fun onNext(value: T) {
        onSuccess(value)
    }

    override fun onError(e: Throwable?) {
        if (!TextUtils.isEmpty(errorMsg)) {
            Toast.makeText(MyApplication.getContext(), errorMsg, Toast.LENGTH_SHORT).show()
            errorMsg?.let { onFailure(-1, it) }
        } else if (e is HttpException) {
            Toast.makeText(MyApplication.getContext(), "网络异常", Toast.LENGTH_SHORT).show()
            onFailure(-1, "网络异常")
        } else if (e is OtherException) {
            Toast.makeText(MyApplication.getContext(), e.message, Toast.LENGTH_SHORT).show()
            onFailure(e.errorCode, e.message)
        } else {
            Toast.makeText(MyApplication.getContext(), "未知错误", Toast.LENGTH_SHORT).show()
            onFailure(-1,"未知错误")
        }
    }

    protected abstract fun start()
    protected abstract fun onSuccess(t: T)
    protected abstract fun onFailure(code: Int, errorMsg: String)

}