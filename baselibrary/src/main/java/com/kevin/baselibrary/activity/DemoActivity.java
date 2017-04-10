package com.kevin.baselibrary.activity;

import android.os.Bundle;
import android.os.Message;

import com.bailiangjin.uilibrary.activity.SuperBaseActivity;
import com.kevin.baselibrary.R;

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
    protected void beforeViewBind(Bundle savedInstanceState) {
        //TODO: 出事化Intent 传入的参数
    }



    @Override
    protected void initView(Bundle savedInstanceState) {
        //TODO: 初始化UI
    }


    @Override
    protected void initData(Bundle savedInstanceState) {
        //TODO: 初始化逻辑
    }





    @Override
    protected void handleMsg(Message msg) {
        //TODO: handler msg 回调处理处

    }

    @Override
    protected boolean isHideBar() {
        return false;
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

    @Override
    public void setStatusBar() {

    }

    @Override
    public void bindView() {

    }

    @Override
    public void unbindView() {

    }
}
