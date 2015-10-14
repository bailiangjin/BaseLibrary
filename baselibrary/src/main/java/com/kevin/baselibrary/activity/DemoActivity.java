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
    protected void initView() {
        //TODO: 初始化UI

    }

    @Override
    protected void initBaseUI() {
        //TODO: 初始化BaseActivity UI 具体Activity 不需要实现
    }

    @Override
    protected void initLogic() {
        //TODO: 初始化逻辑
    }

    @Override
    protected void startLogic() {
        //TODO: 开始执行业务逻辑 耗时操作等 不适合放到 onCreate 中的逻辑 放到此处执行
    }


    @Override
    protected int getLayoutResId() {
        //TODO: 初始化页面根布局
        return R.layout.activity_demo;
    }


    @Override
    protected void onStart() {
        super.onStart();

        show("测试");
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
