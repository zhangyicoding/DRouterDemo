package com.example.login_api

import com.didi.drouter.annotation.Interceptor
import com.didi.drouter.api.DRouter
import com.didi.drouter.api.Extend.Cache.SINGLETON
import com.didi.drouter.page.IPageBean
import com.didi.drouter.page.IPageRouter
import com.didi.drouter.router.IRouterInterceptor
import com.didi.drouter.router.Request
import com.example.user_api.IUserApi
import zhangyi.ZYUtil

@Interceptor(global = true, cache = SINGLETON)
class LoginInterceptor : IRouterInterceptor {

    init {
        ZYUtil.e("LoginInterceptor init")
    }

    override fun handle(request: Request) {
        if (needRedirect(request)) {
//            request.setRedirect("/login/username")
            request.interceptor.onInterrupt()

            val router = DRouter.build(IPageRouter::class.java).getService()
            ZYUtil.e("login interceptor, router is ${router.javaClass}")
            router.showPage(IPageBean.DefPageBean("/login/username"))
            return
        }
        request.interceptor.onContinue()
    }

    private fun needRedirect(request: Request): Boolean {
        val uri = request.uri.toString()
        ZYUtil.e("login interceptor handle, uri=${uri}")
        when (uri) {
            "/mine/profile" -> {
                val userApi = DRouter.build(IUserApi::class.java).getService()
                if (userApi.isLogin().not()) {
                    return true
                }
            }
        }
        return false
    }
}