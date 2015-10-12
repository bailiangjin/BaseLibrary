package com.kevin.baselibrary.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.kevin.baselibrary.listener.HomeListener;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/9/28 23:10
 */
public class SuperBaseActivity extends FragmentActivity {

    protected HomeListener homeListener;

    /**
     * show toast by string
     *
     * @param string
     */
    protected void show(String string) {
        ToastUtils.shortShow(SuperBaseActivity.this, string);
    }

    /**
     * show toast by res id
     *
     * @param resId
     */
    protected void show(int resId) {
        ToastUtils.shortShow(SuperBaseActivity.this, resId);
    }

    /**
     * long toast
     *
     * @param string
     */
    protected void longShow(String string) {
        ToastUtils.longShow(SuperBaseActivity.this, string);
    }

    /**
     * long toast
     *
     * @param resId
     */
    protected void longShow(int resId) {
        ToastUtils.longShow(SuperBaseActivity.this, resId);
    }


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
        homeListener = new HomeListener(SuperBaseActivity.this);
        homeListener.setOnHomePressedListener(new HomeListener.OnHomePressedListener() {

            @Override
            public void onHomePressed() {
                LogUtils.e("onHomePressed:::SuperBaseActivity");
                SuperBaseActivity.this.onHomePressed();
            }

            @Override
            public void onHomeLongPressed() {
                LogUtils.e("onHomeLongPressed:::SuperBaseActivity");
                SuperBaseActivity.this.onHomeLongPressed();
            }
        });
        homeListener.startWatch();
    }

    protected  void onHomePressed(){

    }

    protected  void onHomeLongPressed(){

    }


}




