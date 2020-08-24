package com.wujie.kotlinwanandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.wujie.kotlinwanandroid.bean.ProjectType
import com.wujie.kotlinwanandroid.ui.project.ProjectListFragment

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 16:37
 *  @Description：
 **/
class ProjectPagerAdapter(fragmentManager: FragmentManager, var projectTypeList:MutableList<ProjectType>) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return ProjectListFragment.instantiate(projectTypeList[position].id)
    }

    override fun getCount(): Int {
        return projectTypeList?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return projectTypeList[position].name
    }
}