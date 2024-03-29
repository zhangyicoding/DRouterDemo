package com.example.base.binding

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.base.BaseActivity

abstract class BindingActivity<VB : ViewBinding> : BaseActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getViewBinding().let {
            binding = it
            binding.root
        })
    }

    protected abstract fun getViewBinding(): VB
}
