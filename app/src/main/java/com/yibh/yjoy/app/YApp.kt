package com.yibh.yjoy.app

import android.app.Application
import com.taobao.weex.InitConfig
import com.taobao.weex.WXSDKEngine
import com.yibh.yjoy.mvp.ui.ImageWeexAdapter


class YApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val config = InitConfig.Builder().setImgAdapter(ImageWeexAdapter()).build()
        WXSDKEngine.initialize(this, config)
    }
}