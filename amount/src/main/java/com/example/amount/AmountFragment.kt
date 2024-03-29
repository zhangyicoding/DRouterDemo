package com.example.amount

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.didi.drouter.page.IPageBean
import com.didi.drouter.page.IPageRouter
import com.example.amount.databinding.FragmentAmountBinding
import com.example.base.binding.BindingFragment
import zhangyi.ZYUtil

@Router(uri = "/amount/amount")
class AmountFragment : BindingFragment<FragmentAmountBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAmountBinding {
        return FragmentAmountBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {
            val router = DRouter.build(IPageRouter::class.java).getService()
            router.showPage(IPageBean.DefPageBean("/amount/record"))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ZYUtil.e("amount onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ZYUtil.e("amount onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ZYUtil.e("amount onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        ZYUtil.e("amount onStart")
    }

    override fun onResume() {
        super.onResume()
        ZYUtil.e("amount onResume")
    }

    override fun onPause() {
        super.onPause()
        ZYUtil.e("amount onPause")
    }

    override fun onStop() {
        super.onStop()
        ZYUtil.e("amount onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        ZYUtil.e("amount onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        ZYUtil.e("amount onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        ZYUtil.e("amount onDetach")
    }
}