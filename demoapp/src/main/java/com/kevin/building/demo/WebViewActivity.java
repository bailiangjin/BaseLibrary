package com.kevin.building.demo;

import android.content.DialogInterface;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

import com.kevin.baselibrary.utils.WebViewUtils;
import com.kevin.baselibrary.widget.listener.PNDialogListener;
import com.kevin.baselibrary.widget.utils.DialogUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/12/13 01:00
 */
public class WebViewActivity extends BaseActivity {

    private WebView webView;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initView() {
        commonTitleView.setTitleText("测试WebView");
        commonTitleView.setRightBtnText("关闭");
        commonTitleView.setRightBtnVisibility(View.VISIBLE);
        commonTitleView.setRightButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showBackToSourceDialog();
            }
        });

        commonTitleView.setLeftButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onWebViewBack();
            }
        });
        webView = (WebView) findViewById(R.id.webview_test);
        //WebViewUtils.load(webView,"file:///android_asset/html/test.html");
        WebViewUtils.load(webView, "http://www.baidu.com");

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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return onWebViewBack();
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * WebView 返回事件
     * @return
     */
    private boolean onWebViewBack() {
        if (webView.canGoBack()) {
            webView.goBack();// 返回前一个页面
            shortToast("返回上一页");
            return true;
        } else {
            showBackToSourceDialog();
            return true;
        }
    }

    private void showBackToSourceDialog() {
        DialogUtils.showPNDialog(WebViewActivity.this, "确定关闭当前页面？", true, new PNDialogListener() {
            @Override
            public void onPositive(DialogInterface dialog, int which) {
                shortToast("返回源页面");
                //关闭当前Activity
                WebViewActivity.this.finish();
            }

            @Override
            public void onNegative(DialogInterface dialog, int which) {
                //不做处理
            }
        });
    }


}
