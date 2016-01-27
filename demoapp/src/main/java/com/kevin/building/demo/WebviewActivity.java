package com.kevin.building.demo;

import android.os.Message;
import android.view.View;
import android.webkit.WebView;

import com.kevin.baselibrary.utils.WebViewUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/12/13 01:00
 */
public class WebviewActivity extends BaseActivity {

    private WebView webView;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.webview_test);
        WebViewUtils.load(webView,"file:///android_asset/html/test.html");

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void onViewClick(View v) {

    }

    @Override
    protected void handleMsg(Message msg) {

    }
}
