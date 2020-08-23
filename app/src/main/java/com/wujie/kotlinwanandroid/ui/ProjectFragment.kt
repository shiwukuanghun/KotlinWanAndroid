package com.wujie.kotlinwanandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wujie.kotlinwanandroid.R

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/22 23:30
 *  @Description：
 **/
class ProjectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_project, container, false)
        return view
    }

}