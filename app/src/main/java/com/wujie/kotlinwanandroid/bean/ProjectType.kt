package com.wujie.kotlinwanandroid.bean

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 16:31
 *  @Description：
 **/
data class ProjectType(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)