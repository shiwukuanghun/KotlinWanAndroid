package com.wujie.kotlinwanandroid.ui.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.wujie.kotlinwanandroid.R
import com.wujie.kotlinwanandroid.adapter.ProjectPagerAdapter
import com.wujie.kotlinwanandroid.bean.ProjectType
import com.wujie.kotlinwanandroid.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_project.view.*

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/22 23:30
 *  @Description：
 **/
class ProjectFragment : BaseFragment<ProjectPresenter, ProjectContact.View>(), ProjectContact.View {

    private lateinit var mTblProject : TabLayout
    private lateinit var mVpProject : ViewPager

    override fun getLayoutId(): Int {
        return R.layout.fragment_project
    }

    override fun init(view: View) {
        mTblProject = view.tbl_project
        mVpProject = view.vp_project
        mPresenter.getProjectType()
    }

    override fun createPresenter(): ProjectPresenter {
        return ProjectPresenter()
    }

    override fun getProjectTypeSuccess(projectTypeList: MutableList<ProjectType>) {
        var projectPagerAdapter = ProjectPagerAdapter(childFragmentManager, projectTypeList)
        mVpProject.adapter = projectPagerAdapter
        mTblProject.setupWithViewPager(mVpProject)
    }

}