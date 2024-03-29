package com.example.user

import com.didi.drouter.annotation.Service
import com.example.user_api.IUserApi

@Service(function = [IUserApi::class])
class UserApiImpl : IUserApi {

    override fun setLogin(isLogin: Boolean) {
        User.isLogin = isLogin
    }

    override fun isLogin(): Boolean {
        return User.isLogin
    }
}