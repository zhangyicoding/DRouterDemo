package com.example.base

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.didi.drouter.page.IPageBean
import com.didi.drouter.page.IPageBean.EmptyPageBean
import com.didi.drouter.page.IPageRouter.IPageObserver
import com.didi.drouter.page.RouterPageAbs

class MyPageRouter(
    private val manager: FragmentManager,
    @param:IdRes private val containerId: Int
) : RouterPageAbs() {

    private var fragment: Fragment? = null

    /**
     * 跳转Fragment，自定义事务，管理方式和JetPack Navigation对齐
     */
    override fun showPage(bean: IPageBean) {
        fragment = createFragment(bean.pageUri)
        putArgsForFragment(fragment, bean.pageInfo)
        manager.beginTransaction()
            .setCustomAnimations(// 动画必须在replace之前
                R.anim.slide_enter_anim,
                R.anim.slide_pop_exit_anim,
                R.anim.slide_pop_enter_anim,
                R.anim.slide_exit_anim
            )
            .replace(containerId, fragment!!)
            .addToBackStack(bean.pageUri)
            .commitAllowingStateLoss()
        notifyPageChanged(bean, IPageObserver.CHANGED_BY_REPLACE, false)
    }

    /**
     * 对当前Fragment弹栈，返回上一层级
     */
    override fun popPage() {
        if (fragment != null) {
            manager.popBackStack()
            notifyPageChanged(EmptyPageBean(), IPageObserver.CHANGED_BY_POP, false)
            fragment = null
        }
    }
}