package com.wujie.kotlinwanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.wujie.kotlinwanandroid.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    private var mHomeFragment: HomeFragment? = null
    private var mKnowledgeFragment: KnowledgeFragment? = null
    private var mNavigationFragment: NavigationFragment? = null
    private var mProjectFragment: ProjectFragment? = null
    private var mMineFragment: MineFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rg_container.setOnCheckedChangeListener(this)
        rg_container.check(R.id.rb_home)
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideAllFragment(transaction)
        when (checkedId) {
            R.id.rb_home -> {
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment()
                    transaction.add(R.id.fl_container, mHomeFragment!!, "0")
                } else {
                    transaction.show(mHomeFragment!!)
                }
            }
            R.id.rb_knowledge -> {
                if (mKnowledgeFragment == null) {
                    mKnowledgeFragment = KnowledgeFragment()
                    transaction.add(R.id.fl_container, mKnowledgeFragment!!, "1")
                } else {
                    transaction.show(mKnowledgeFragment!!)
                }
            }
            R.id.rb_navigation -> {
                if (mNavigationFragment == null) {
                    mNavigationFragment = NavigationFragment()
                    transaction.add(R.id.fl_container, mNavigationFragment!!, "2")
                } else {
                    transaction.show(mNavigationFragment!!)
                }
            }
            R.id.rb_project -> {
                if (mProjectFragment == null) {
                    mProjectFragment = ProjectFragment()
                    transaction.add(R.id.fl_container, mProjectFragment!!, "3")
                } else {
                    transaction.show(mProjectFragment!!)
                }
            }
            R.id.rb_mine -> {
                if (mMineFragment == null) {
                    mMineFragment = MineFragment()
                    transaction.add(R.id.fl_container, mMineFragment!!, "4")
                } else {
                    transaction.show(mMineFragment!!)
                }
            }
        }
        transaction.commit()
    }

    //    object?.let{//表示object不为null的条件下，才会去执行let函数体
//        it.todo()
//    }
    private fun hideAllFragment(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) } //在mHomeFragment不为空的情况下执行
        mKnowledgeFragment?.let { transaction.hide(it) }
        mNavigationFragment?.let { transaction.hide(it) }
        mProjectFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (mHomeFragment == null && fragment is HomeFragment) {
            mHomeFragment = fragment
            supportFragmentManager.beginTransaction().hide(mHomeFragment!!).commit()
        } else if (mKnowledgeFragment == null && fragment is KnowledgeFragment) {
            mKnowledgeFragment = fragment
            supportFragmentManager.beginTransaction().hide(mKnowledgeFragment!!).commit()
        } else if (mNavigationFragment == null && fragment is NavigationFragment) {
            mNavigationFragment = fragment
            supportFragmentManager.beginTransaction().hide(mNavigationFragment!!).commit()
        } else if (mProjectFragment == null && fragment is ProjectFragment) {
            mProjectFragment = fragment
            supportFragmentManager.beginTransaction().hide(mProjectFragment!!).commit()
        } else if (mMineFragment == null && fragment is MineFragment) {
            mMineFragment = fragment
            supportFragmentManager.beginTransaction().hide(mMineFragment!!).commit()
        }
    }
}