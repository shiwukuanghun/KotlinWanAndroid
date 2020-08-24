package com.wujie.kotlinwanandroid.bean

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 13:14
 *  @Description：
 **/
data class Knowledge(
    val children: List<Children>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)

data class Children(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)