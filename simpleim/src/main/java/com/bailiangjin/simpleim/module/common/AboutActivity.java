package com.bailiangjin.simpleim.module.common;

import android.os.Bundle;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.appcommon.base.BaseActivity;

/**
 * 关于页
 * Created by bailiangjin on 16/9/29.
 */
public class AboutActivity extends BaseActivity{
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_about;
    }

    @Override
    protected void beforeViewBind(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleBarBuilder.setTitleText("关于");
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
