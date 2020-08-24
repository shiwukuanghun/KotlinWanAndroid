package com.wujie.kotlinwanandroid.net

import com.wujie.kotlinwanandroid.bean.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 16:52
 *  @Description：
 **/
interface ApiService {

    //首页文章列表
    @GET("article/list/{page}/json")
    fun getHomeList(@Path("page") page : Int) :Observable<BaseBean<PageListDataBean<HomeBean>>>

    /**
     * 知识体系
     */
    @GET("tree/json")
    fun getKnowledge() : Observable<BaseBean<MutableList<Knowledge>>>

    /**
     * 导航
     */
    @GET("navi/json")
    fun getNavigation() : Observable<BaseBean<MutableList<Navigation>>>

    @GET("project/tree/json")
    fun getProjectType() : Observable<BaseBean<MutableList<ProjectType>>>

    @GET("project/list/1/json")
    fun getProjectList(@Query("cid") cid :Int) :Observable<BaseBean<PageListDataBean<Project>>>
}