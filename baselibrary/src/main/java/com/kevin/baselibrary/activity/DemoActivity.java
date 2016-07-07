package com.kevin.baselibrary.activity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.base.SuperBaseActivity;

/**
 * 示例 Activity类
 */
public class DemoActivity extends SuperBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: 子类不必须覆盖 父类 onCreate 方法 但需 实现以下几个方法
    }

    @Override
    protected void initIntentData() {

    }


    @Override
    protected void initView() {
        //TODO: 初始化UI

    }


    @Override
    protected void initData() {
        //TODO: 初始化逻辑
    }



    @Override
    protected int getLayoutResId() {
        //TODO: 初始化页面根布局
        return R.layout.activity_demo;
    }



    @Override
    protected void onStart() {
        super.onStart();

        shortToast("测试");
    }


    @Override
    protected void onViewClick(View v) {
        //TODO: 全局点击事件 回调监听处

    }

    @Override
    protected void handleMsg(Message msg) {
        //TODO: handler msg 回调处理处

    }
}
