package com.bailiangjin.simpleim.module.common;

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
    protected void initIntentData() {

    }

    @Override
    protected void initView() {
        titleBarBuilder.setTitleText("关于");
    }

    @Override
    protected void initData() {

    }
}
