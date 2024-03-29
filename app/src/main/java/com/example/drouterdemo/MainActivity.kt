package com.example.drouterdemo

import android.content.Intent
import android.os.Bundle
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.didi.drouter.router.Result
import com.didi.drouter.router.RouterCallback.ActivityCallback
import com.example.base.binding.BindingActivity
import com.example.drouterdemo.databinding.ActivityMainBinding
import zhangyi.ZYUtil

@Router(uri = "/splash")
class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btn.setOnClickListener {
            DRouter.build("/home/main")
                .start(this, object : ActivityCallback() {
                    override fun onActivityResult(resultCode: Int, data: Intent?) {
                        ZYUtil.e("main activity result, resultcode=${resultCode}")
                        if (resultCode == RESULT_OK) {
                            finish()
                        }
                    }

                    override fun onResult(result: Result) {
                        super.onResult(result)
                    }

                })
        }
    }
}