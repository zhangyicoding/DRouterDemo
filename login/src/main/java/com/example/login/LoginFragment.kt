package com.example.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.example.base.binding.BindingFragment
import com.example.login.databinding.FragmentLoginBinding
import com.example.user_api.IUserApi

@Router(uri = "/login/username")
class LoginFragment : BindingFragment<FragmentLoginBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userApi = DRouter.build(IUserApi::class.java).getService()

        binding.switchLogin.setOnCheckedChangeListener { compoundButton, isChecked ->
            userApi.setLogin(isChecked)
        }
    }
}