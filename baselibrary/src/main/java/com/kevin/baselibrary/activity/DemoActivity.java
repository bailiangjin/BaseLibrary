package com.kevin.baselibrary.activity;

import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.base.SuperBaseActivity;

/**
 * 示例 Activity类
 */
public class DemoActivity extends SuperBaseActivity {


    @Override
    protected int getLayoutResId() {
        //TODO: 返回页面layout xml 文件
        return R.layout.activity_demo;
    }


    @Override
    protected void initIntentData() {
        //TODO: 出事化Intent 传入的参数
    }

    @Override
    protected void initBaseView() {

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
    protected void onViewClick(View v) {
        //TODO: 全局点击事件 回调监听处
    }

    @Override
    protected void handleMsg(Message msg) {
        //TODO: handler msg 回调处理处

    }
}
