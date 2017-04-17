package com.bailiangjin.demo.demo;

import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.webkit.WebView;

import com.bailiangjin.demo.R;
import com.bailiangjin.demo.base.BaseActivity;
import com.bailiangjin.uilibrary.titlebar.ItemClickListener;
import com.bailiangjin.uilibrary.widget.PNDialog;
import com.bailiangjin.uilibrary.widget.PNDialogListener;
import com.bailiangjin.utilslibrary.utils.ui.WebViewUtils;

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
    protected void beforeViewBind(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleBarBuilder.setTitleText("测试WebView");
        titleBarBuilder.addItem("关闭", new ItemClickListener() {
            @Override
            public void onClick() {
                showBackToSourceDialog();
            }
        }).build();

        titleBarBuilder.setBackIconClickEvent(new ItemClickListener() {
            @Override
            public void onClick() {
                onWebViewBack();
            }
        });

        webView = (WebView) findViewById(R.id.webview_test);
        //WebViewUtils.load(webView,"file:///android_asset/html/test.html");
//        WebViewUtils.load(webView, "http://www.baidu.com");
        WebViewUtils.load(webView, "http://m.so.xywy.com/comse.php?from=soapp&keyword=%E5%92%B3%E5%97%BD&src=m_so");

    }


    @Override
    protected void initData(Bundle savedInstanceState) {

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
     *
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

        new PNDialog.Builder().setContent("确定关闭当前页面？").create(WebViewActivity.this, new PNDialogListener() {
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

    private long lastMoveEventTime = -1;
    private int eventTimeInterval = 40;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        long eventTime = ev.getEventTime();
        int action = ev.getAction();

        switch (action){
            case MotionEvent.ACTION_MOVE: {
                if ((eventTime - lastMoveEventTime) > eventTimeInterval){
                    lastMoveEventTime = eventTime;
                    return super.onTouchEvent(ev);
                }
                break;
            }
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_UP: {
                return super.onTouchEvent(ev);
            }
        }
        return true;
    }


}
