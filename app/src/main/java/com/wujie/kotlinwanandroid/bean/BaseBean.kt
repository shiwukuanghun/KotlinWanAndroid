package com.wujie.kotlinwanandroid.bean

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 18:10
 *  @Description：
 **/
data class BaseBean<T>(var data: T, var errorCode: Int, var errorMsg: String)