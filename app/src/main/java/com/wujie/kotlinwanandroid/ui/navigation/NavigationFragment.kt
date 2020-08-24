package com.wujie.kotlinwanandroid.ui.navigation

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wujie.kotlinwanandroid.R
import com.wujie.kotlinwanandroid.adapter.NavigationAdapter
import com.wujie.kotlinwanandroid.bean.Navigation
import com.wujie.kotlinwanandroid.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_navigation.view.*
import q.rorbin.verticaltablayout.VerticalTabLayout
import q.rorbin.verticaltablayout.adapter.TabAdapter
import q.rorbin.verticaltablayout.widget.ITabView
import q.rorbin.verticaltablayout.widget.ITabView.TabTitle
import q.rorbin.verticaltablayout.widget.TabView

/**
 *  @Author：created by WuChen
 *  @Time：2020/8/22 23:34
 *  @Description：导航
 **/
class NavigationFragment : BaseFragment<NavigationPresenter, NavigationContact.View>(),
    NavigationContact.View {

    private lateinit var mNavigationAdapter: NavigationAdapter
    private lateinit var mVtl: VerticalTabLayout

    override fun getLayoutId(): Int {
        return R.layout.fragment_navigation
    }

    override fun init(view: View) {
        mVtl = view.vtl
        view.rv_navigation.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context)
        view.rv_navigation.layoutManager = linearLayoutManager
        mNavigationAdapter = NavigationAdapter()
        view.rv_navigation.adapter = mNavigationAdapter
        mPresenter.getNavigation()

        view.rv_navigation.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    var firstVisibleItemPosition =
                        linearLayoutManager.findFirstVisibleItemPosition()
                    mVtl.setTabSelected(firstVisibleItemPosition)
                }
            }
        })

        mVtl.addOnTabSelectedListener(object : VerticalTabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabView?, position: Int) {
            }

            override fun onTabSelected(tab: TabView?, position: Int) {
                var firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()
                var lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()
                if (position < firstVisibleItemPosition) {
                    view.rv_navigation.smoothScrollToPosition(position)
                } else if (position <= lastVisibleItemPosition) {
                    var top = view.rv_navigation.getChildAt(position - firstVisibleItemPosition).top
                    view.rv_navigation.smoothScrollBy(0, top)
                } else {
                    view.rv_navigation.smoothScrollToPosition(position)
                }
            }
        })
    }

    override fun createPresenter(): NavigationPresenter {
        return NavigationPresenter()
    }

    override fun getNavigationSuccess(navigationList: MutableList<Navigation>) {
        mNavigationAdapter.setNewInstance(navigationList)
        mVtl.setTabAdapter(object : TabAdapter {
            override fun getIcon(position: Int): ITabView.TabIcon? {
                return null
            }

            override fun getBadge(position: Int): ITabView.TabBadge? {
                return null
            }

            override fun getBackground(position: Int): Int {
                return 0
            }

            override fun getTitle(position: Int): ITabView.TabTitle {
                return TabTitle.Builder()
                    .setContent(navigationList[position].name)
                    .setTextColor(
                        resources.getColor(R.color.shallow_green),
                        ContextCompat.getColor(context!!, R.color.shallow_grey)
                    )
                    .build()
            }

            override fun getCount(): Int {
                return navigationList?.size ?: 0
            }
        })
    }


//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_navigation, container, false)
//        return view
//    }

}