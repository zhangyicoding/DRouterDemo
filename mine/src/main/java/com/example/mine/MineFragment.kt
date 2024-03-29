package com.example.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.didi.drouter.page.IPageBean
import com.didi.drouter.page.IPageRouter
import com.example.base.binding.BindingFragment
import com.example.mine.databinding.FragmentMineBinding
import com.example.user_api.IUserApi

@Router(uri = "/mine/main")
class MineFragment : BindingFragment<FragmentMineBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMineBinding {
        return FragmentMineBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userApi = DRouter.build(IUserApi::class.java).getService()
        binding.tvAvatar.text = if (userApi.isLogin()) {
            "用户"
        } else {
            "登录"
        }

        binding.tvAvatar.setOnClickListener {
            val router = DRouter.build(IPageRouter::class.java).getService()
            router.showPage(IPageBean.DefPageBean("/mine/profile"))
        }
    }


}