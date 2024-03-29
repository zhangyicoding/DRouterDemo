package com.example.amount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.didi.drouter.page.IPageRouter
import com.example.amount.databinding.FragmentRecordBinding
import com.example.base.binding.BindingFragment

@Router(uri = "/amount/record")
class RecordFragment : BindingFragment<FragmentRecordBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRecordBinding {
        return FragmentRecordBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {
            val router = DRouter.build(IPageRouter::class.java).getService()
            router.popPage()
        }
    }
}