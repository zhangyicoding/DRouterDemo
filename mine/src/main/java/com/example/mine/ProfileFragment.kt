package com.example.mine

import android.view.LayoutInflater
import android.view.ViewGroup
import com.didi.drouter.annotation.Router
import com.example.base.binding.BindingFragment
import com.example.login_api.LoginInterceptor
import com.example.mine.databinding.FragmentProfileBinding

@Router(uri = "/mine/profile", interceptor = [LoginInterceptor::class])
class ProfileFragment : BindingFragment<FragmentProfileBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater, container, false)
    }


}