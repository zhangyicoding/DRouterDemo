package com.example.user_api

interface IUserApi {
    fun setLogin(isLogin: Boolean)
    fun isLogin(): Boolean
}