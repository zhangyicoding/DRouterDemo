package com.example.home

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.didi.drouter.annotation.Router
import zhangyi.ZYUtil

@Router(uri = "/view/my_view")
class MyView : View {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        ZYUtil.e("MyView init")
    }

}