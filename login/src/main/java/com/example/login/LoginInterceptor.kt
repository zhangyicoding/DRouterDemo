package com.example.login

import com.didi.drouter.annotation.Interceptor
import com.didi.drouter.api.DRouter
import com.didi.drouter.api.Extend.Cache.SINGLETON
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
            request.setRedirect("/login/username")
        }
        request.interceptor.onContinue()
    }

    private fun needRedirect(request: Request): Boolean {
        val uri = request.uri.toString()
        ZYUtil.e("login interceptor handle, uri=${uri}")
        when (uri) {
            "/amount/record" -> {
                val userApi = DRouter.build(IUserApi::class.java).getService()
                if (userApi.isLogin().not()) {
                    return true
                }
            }
        }
        return false
    }
}