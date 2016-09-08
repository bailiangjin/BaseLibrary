package com.kevin.building.demo;

import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

import com.kevin.baselibrary.interfaze.listener.CommonTitleListener;
import com.kevin.baselibrary.utils.WebViewUtils;
import com.kevin.baselibrary.widget.utils.PNDialog;
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
        commonTitleView.setTitleViewListener(new CommonTitleListener() {
            @Override
            public boolean onRightImgClick() {
                return false;
            }

            @Override
            public boolean onLeftImgClick() {
                onWebViewBack();
               return true;
            }

            @Override
            public boolean onRightBtnClick() {
                showBackToSourceDialog();
                return true;
            }
        });
        webView = (WebView) findViewById(R.id.webview_test);
        //WebViewUtils.load(webView,"file:///android_asset/html/test.html");
        WebViewUtils.load(webView, "http://www.baidu.com");

    }



    @Override
    protected void initData() {

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

        new PNDialog.Builder().setContent("确定关闭当前页面？").create(WebViewActivity.this, new com.kevin.baselibrary.widget.utils.PNDialogListener() {
            @Override
            public void onPositive() {
                shortToast("返回源页面");
                //关闭当前Activity
                WebViewActivity.this.finish();
            }

            @Override
            public void onNegative() {

            }
        }).show();

    }


}
