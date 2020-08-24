package com.wujie.kotlinwanandroid.net

import android.net.http.SslCertificate
import com.wujie.kotlinwanandroid.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL
import java.util.concurrent.TimeUnit

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 15:59
 *  @Description：
 **/
class RxRetrofit {

    private var mOkHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .sslSocketFactory(
            SSLSocketClient.getSSLSocketFactory(),
            SSLSocketClient.getCustomTrustManager()
        )
        .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
        .build()

    private lateinit var mApiService: ApiService

    companion object {

        private var instance: RxRetrofit? = null
            get() {
                if (field == null) {
                    field = RxRetrofit()
                }
                return field
            }

        @Synchronized
        fun get(): RxRetrofit {
            return instance!!
        }

        fun <T> createApi(clazz: Class<T>, url: String): T {
            var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(clazz)
        }

        private val mHttpLoggingInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        private var mOkHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .sslSocketFactory(
                SSLSocketClient.getSSLSocketFactory(),
                SSLSocketClient.getCustomTrustManager()
            )
            .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
            .build()

        fun getApi(): ApiService {
            return initRetrofit().create(ApiService::class.java)
        }

        private fun initRetrofit() : Retrofit {
            var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(Constant.BaseUrl)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }

    fun initRetrofit() {
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constant.BaseUrl)
            .client(mOkHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        mApiService = retrofit.create(ApiService::class.java)
    }

    fun getApi(): ApiService {
        return mApiService
    }
}