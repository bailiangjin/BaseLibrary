package com.kevin.baselibrary.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.kevin.baselibrary.listener.HomeListener;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/9/28 23:10
 */
public abstract class SuperBaseActivity extends FragmentActivity {

    protected HomeListener homeListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化UI
        initUI();
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

    //当前类实现 方法

    /**
     * 初始化当前Activity根界面 不允许子类覆盖
     */
    private void initUI() {
        setContentView(getLayoutResID());
    }


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

    protected void onHomePressed() {

    }

    protected void onHomeLongPressed() {

    }

    //子类必须实现的抽象方法

    /**
     * 获取页面Layout ID
     *
     * @return
     */
    protected abstract int getLayoutResID();

    /**
     * 全局点击事件
     *
     * @param v
     */
    protected abstract void onViewClick(View v);


}




