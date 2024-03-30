package com.example.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.didi.drouter.annotation.Router
import com.example.base.binding.BindingFragment
import com.example.login_api.LoginInterceptor
import com.example.mine.databinding.FragmentProfileBinding

@Router(uri = "/mine/profile/<nick>")
class ProfileFragment : BindingFragment<FragmentProfileBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nick = requireArguments().getString("nick")
        binding.tvNick.text = nick
    }
}