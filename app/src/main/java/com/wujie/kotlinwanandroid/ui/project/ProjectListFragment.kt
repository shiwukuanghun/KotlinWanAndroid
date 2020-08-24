package com.wujie.kotlinwanandroid.ui.project

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.wujie.kotlinwanandroid.R
import com.wujie.kotlinwanandroid.adapter.ProjectAdapter
import com.wujie.kotlinwanandroid.bean.Project
import com.wujie.kotlinwanandroid.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_project_list.view.*

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/24 16:45
 *  @Description：
 **/
class ProjectListFragment : BaseFragment<ProjectListPresenter, ProjectListContact.View>(),
    ProjectListContact.View {

    private lateinit var mProjectAdapter: ProjectAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_project_list
    }

    override fun init(view: View) {
        view.rv_project.setHasFixedSize(true)
        view.rv_project.layoutManager = LinearLayoutManager(context)
        mProjectAdapter = ProjectAdapter()
        view.rv_project.adapter = mProjectAdapter
        val bundle = arguments;
        val cid = bundle!!.getInt("ID")
        mPresenter.getProjectList(cid)
    }

    override fun createPresenter(): ProjectListPresenter {
        return ProjectListPresenter()
    }

    companion object {
        fun instantiate(id: Int): ProjectListFragment {
            var projectListFragment = ProjectListFragment()
            var bundle = Bundle()
            bundle.putInt("ID", id)
            projectListFragment.arguments = bundle
            return projectListFragment
        }
    }

    override fun getProjectListSuccess(projectList: MutableList<Project>) {
        mProjectAdapter.setNewInstance(projectList)
    }
}