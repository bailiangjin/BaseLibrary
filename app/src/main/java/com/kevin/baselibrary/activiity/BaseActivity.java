package com.kevin.baselibrary.activiity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.kevin.baselibrary.listener.HomeListener;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/9/28 23:10
 */
public class BaseActivity extends FragmentActivity {


    /**
     * show toast by string
     *
     * @param string
     */
    protected void show(String string) {
        ToastUtils.shortShow(BaseActivity.this, string);
    }

    /**
     * show toast by res id
     *
     * @param resId
     */
    protected void show(int resId) {
        ToastUtils.shortShow(BaseActivity.this, resId);
    }

    /**
     * long toast
     *
     * @param string
     */
    protected void longShow(String string) {
        ToastUtils.longShow(BaseActivity.this, string);
    }

    /**
     * long toast
     *
     * @param resId
     */
    protected void longShow(int resId) {
        ToastUtils.longShow(BaseActivity.this, resId);
    }
    protected HomeListener homeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerHomeListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        homeListener.startWatch();
    }


    @Override
    protected void onPause() {
        super.onPause();
        homeListener.stopWatch();
    }


    /**
     * 注册Home键的监听
     */
    protected void registerHomeListener() {
        homeListener = new HomeListener(BaseActivity.this);
        homeListener.setOnHomePressedListener(new HomeListener.OnHomePressedListener() {

            @Override
            public void onHomePressed() {
                LogUtils.e("onHomePressed:::SuperBaseActivity");
                BaseActivity.this.onHomePressed();
            }

            @Override
            public void onHomeLongPressed() {
                LogUtils.e("onHomeLongPressed:::SuperBaseActivity");
                BaseActivity.this.onHomeLongPressed();
            }
        });
        homeListener.startWatch();
    }

    protected  void onHomePressed(){

    }

    protected  void onHomeLongPressed(){

    }


}




