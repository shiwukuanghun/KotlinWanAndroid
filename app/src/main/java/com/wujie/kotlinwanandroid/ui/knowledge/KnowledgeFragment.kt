package com.wujie.kotlinwanandroid.ui.knowledge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wujie.kotlinwanandroid.R
import com.wujie.kotlinwanandroid.adapter.KnowledgeAdapter
import com.wujie.kotlinwanandroid.bean.ProjectType
import com.wujie.kotlinwanandroid.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_knowledge.view.*

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/22 23:28
 *  @Description：
 **/
class KnowledgeFragment : BaseFragment<KnowledgePresenter, KnowledgeContact.View>(), KnowledgeContact.View {

    private lateinit var mDataList : MutableList<ProjectType>
    private lateinit var mKnowledgeAdapter: KnowledgeAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_knowledge
    }

    override fun init(view: View) {
        view.rv_knowledge.setHasFixedSize(true)
        view.rv_knowledge.layoutManager = LinearLayoutManager(context)
        mDataList = mutableListOf()
        mKnowledgeAdapter = KnowledgeAdapter(mDataList)
        view.rv_knowledge.adapter = mKnowledgeAdapter
        mPresenter.getKnowledge()
    }

    override fun createPresenter(): KnowledgePresenter {
        return KnowledgePresenter()
    }

    override fun getKnowledgeSuccess(projectTypeList: MutableList<ProjectType>) {
        mDataList.addAll(projectTypeList)
        mKnowledgeAdapter.notifyDataSetChanged()
    }


}