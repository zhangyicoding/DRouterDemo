package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.didi.drouter.annotation.Router
import com.didi.drouter.page.IPageBean
import com.didi.drouter.page.RouterPageSingle
import com.example.base.binding.BindingFragment
import com.example.home.databinding.FragmentHomeBinding
import zhangyi.ZYUtil

@Router(uri = "/home/main/<token>/<type>")
class HomeFragment : BindingFragment<FragmentHomeBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val token = requireArguments().getString("token")
        val type = requireArguments().getString("type")?.toInt()
        ZYUtil.e("home fragment, token=$token, type=$type")

        val router = RouterPageSingle(childFragmentManager, binding.fragmentContainerView.id)

        binding.bottomRadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                binding.amountBtn.id -> {
                    router.showPage(IPageBean.DefPageBean("/amount/amount"))
                }

                binding.mineBtn.id -> {
                    router.showPage(IPageBean.DefPageBean("/mine/main"))
                }
            }
        }

        binding.bottomRadioGroup.check(if (type == 0) binding.amountBtn.id else binding.mineBtn.id)
    }
}