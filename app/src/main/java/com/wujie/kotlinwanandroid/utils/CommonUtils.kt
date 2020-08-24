package com.wujie.kotlinwanandroid.utils

import android.graphics.Color
import java.util.*

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 14:45
 *  @Description：
 **/
object CommonUtils {

    fun randomColor() : Int {
        val random = Random()
        //0-190, 如果颜色值过大,就越接近白色,就看不清了,所以需要限定范围
        //0-190, 如果颜色值过大,就越接近白色,就看不清了,所以需要限定范围
        val red = random.nextInt(150)
        //0-190
        //0-190
        val green = random.nextInt(150)
        //0-190
        //0-190
        val blue = random.nextInt(150)
        //使用rgb混合生成一种新的颜色,Color.rgb生成的是一个int数
        //使用rgb混合生成一种新的颜色,Color.rgb生成的是一个int数
        return Color.rgb(red, green, blue)
    }

}