package com.wujie.kotlinwanandroid.bean

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 18:12
 *  @Description：
 **/
data class PageListDataBean<T>(
    var curPage: Int,
    var offset: Int,
    var over: Boolean,
    var pageCount: Int,
    var size: Int,
    var total: Int,
    var datas: MutableList<T>
)