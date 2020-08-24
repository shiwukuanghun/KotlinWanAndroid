package com.wujie.kotlinwanandroid.net

import com.wujie.kotlinwanandroid.bean.BaseBean
import com.wujie.kotlinwanandroid.bean.HomeBean
import com.wujie.kotlinwanandroid.bean.PageListDataBean
import com.wujie.kotlinwanandroid.bean.ProjectType
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 16:52
 *  @Description：
 **/
interface ApiService {

    //首页文章列表
    @GET("article/list/{page}/json")
    fun getHomeList(@Path("page") page : Int) :Observable<BaseBean<PageListDataBean<HomeBean>>>

    @GET("tree/json")
    fun getKnowledge() : Observable<BaseBean<MutableList<ProjectType>>>

}