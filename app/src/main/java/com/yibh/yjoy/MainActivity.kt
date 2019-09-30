package com.yibh.yjoy

import android.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.taobao.weex.IWXRenderListener
import com.taobao.weex.WXSDKInstance
import com.taobao.weex.common.WXRenderStrategy


class MainActivity : AppCompatActivity(), IWXRenderListener {
    var mWXSDKInstance: WXSDKInstance? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mWXSDKInstance = WXSDKInstance(this)
        mWXSDKInstance!!.registerRenderListener(this)
        /**
         * bundleUrl source http://dotwe.org/vue/38e202c16bdfefbdb88a8754f975454c
         */
        val pageName = "WXSample"
        val bundleUrl = "http://dotwe.org/raw/dist/38e202c16bdfefbdb88a8754f975454c.bundle.wx"
        mWXSDKInstance!!.renderByUrl(pageName, bundleUrl, null, null, WXRenderStrategy.APPEND_ASYNC)
    }

    override fun onRefreshSuccess(instance: WXSDKInstance?, width: Int, height: Int) {

    }

    override fun onException(instance: WXSDKInstance?, errCode: String?, msg: String?) {
    }

    override fun onViewCreated(instance: WXSDKInstance?, view: View?) {
        setContentView(view)
    }

    override fun onRenderSuccess(instance: WXSDKInstance?, width: Int, height: Int) {

    }

    override fun onPause() {
        super.onPause()
        mWXSDKInstance?.onActivityPause()
    }

    override fun onStop() {
        super.onStop()
        mWXSDKInstance?.onActivityStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mWXSDKInstance?.onActivityDestroy()
    }

}
