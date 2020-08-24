package com.wujie.kotlinwanandroid.net

import java.lang.RuntimeException

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/23 14:28
 *  @Description：
 **/
data class OtherException(var errorCode : Int, override var message :String) : RuntimeException() {

}