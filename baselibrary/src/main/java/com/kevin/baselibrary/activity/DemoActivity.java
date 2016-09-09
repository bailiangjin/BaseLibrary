package com.kevin.baselibrary.activity;

import android.os.Message;

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
    protected void handleMsg(Message msg) {
        //TODO: handler msg 回调处理处

    }

    @Override
    public void shortToast(String string) {

    }

    @Override
    public void shortToast(int resId) {

    }

    @Override
    public void longToast(String string) {

    }

    @Override
    public void longToast(int resId) {

    }

    @Override
    public void showLoadDataDialog() {

    }

    @Override
    public void showProgressDialog(String content) {

    }

    @Override
    public void hideProgressDialog() {

    }
}
