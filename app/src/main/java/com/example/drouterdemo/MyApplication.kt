package com.example.drouterdemo

import android.app.Application
import com.didi.drouter.api.DRouter

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DRouter.init(this)
    }
}