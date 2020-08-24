package com.wujie.kotlinwanandroid.net

import com.wujie.kotlinwanandroid.bean.BaseBean
import io.reactivex.*
import io.reactivex.functions.Function
import java.lang.Exception

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 21:12
 *  @Description：
 **/
class RxHelper {

    /*    public static <T> ObservableTransformer<BaseBean<T>, T> handleResult2() {
        return httpResponseObservable ->
                httpResponseObservable.flatMap((Function<BaseBean<T>, Observable<T>>) baseResponse -> {
                    if(baseResponse.getErrorCode() == 0
                            && baseResponse.getData() != null) {
                        return createData(baseResponse.getData());
                    } else {
                        return Observable.error(new OtherException(baseResponse.getErrorCode(), baseResponse.getErrorMsg()));
                    }
                });
    }*/

    companion object{
        //简化后的样子
        fun <T> handleResult2() : ObservableTransformer<BaseBean<T>, T> {
            return ObservableTransformer<BaseBean<T>, T> { upstream ->
                upstream!!.flatMap { t ->
                    if (t!!.errorCode ==0 && t.data!=null) {
                        createData(t!!.data)
                    } else {
                        Observable.error(OtherException(t!!.errorCode, t!!.errorMsg))
                    }
                }
            }
        }

        //原样
        fun <T> handleResult() : ObservableTransformer<BaseBean<T>, T> {
            return object :ObservableTransformer<BaseBean<T>, T>{
                override fun apply(upstream: Observable<BaseBean<T>>?): ObservableSource<T> {
                    return upstream!!.flatMap(object : Function<BaseBean<T>, Observable<T>>{
                        override fun apply(t: BaseBean<T>?): Observable<T> {
                            return if (t!!.errorCode ==0 && t.data!=null) {
                                createData(t!!.data)
                            } else {
                                Observable.error(OtherException(t!!.errorCode, t!!.errorMsg))
                            }
                        }
                    })
                }
            }
        }


        private fun <T> createData(t:T) : Observable<T> {
            return Observable.create { e ->
                try {
                    e?.onNext(t)
                    e?.onComplete()
                }catch (e1:Exception) {
                    e?.onError(e1)
                }
            }
        }

        private fun <T> createData2(t:T) : Observable<T> {
            return Observable.create(object : ObservableOnSubscribe<T>{
                override fun subscribe(e: ObservableEmitter<T>?) {
                    try {
                        e?.onNext(t)
                        e?.onComplete()
                    }catch (e1:Exception) {
                        e?.onError(e1)
                    }
                }
            })
        }

    }

}