package com.example.home

import android.os.Bundle
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.didi.drouter.page.IPageBean
import com.didi.drouter.page.IPageRouter
import com.didi.drouter.store.ServiceKey
import com.example.base.MyPageRouter
import com.example.base.binding.BindingActivity
import com.example.home.databinding.ActivityHomeBinding
import zhangyi.ZYUtil

@Router(uri = "/home/container")
class HomeActivity : BindingActivity<ActivityHomeBinding>() {

    override fun getViewBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setResult(RESULT_OK)

        val router = MyPageRouter(supportFragmentManager, binding.fragmentContainerView.id)

        DRouter.register(
            ServiceKey.build(IPageRouter::class.java).setLifecycle(lifecycle),
            router
        )

        // 可选
        router.addPageObserver(
            { from, to, changeType ->
                ZYUtil.e("home, from=${from.pageUri}, to=${to.pageUri}, type=${changeType}")
            },
            true,
            this
        )

        router.showPage(IPageBean.DefPageBean("/home/main/zhangyi18/0"))
    }

    /**
     * 在容器Activity中配合回退点击事件监听back stack
     * 当需要回退至上一层级Fragment时，super.onBackPressed()自动处理回退操作
     * 当处于底层Fragment并期望关闭页面时，直接finish即可
     */
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            super.onBackPressed()
        } else {
            finish()
        }
    }
}