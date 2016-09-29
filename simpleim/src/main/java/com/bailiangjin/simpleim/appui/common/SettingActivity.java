package com.bailiangjin.simpleim.appui.common;

import android.view.View;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.base.BaseActivity;
import com.bailiangjin.simpleim.utils.ActivityUtils;

import butterknife.OnClick;

/**
 * 关于页
 * Created by bailiangjin on 16/9/29.
 */
public class SettingActivity extends BaseActivity{
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initIntentData() {

    }

    @Override
    protected void initView() {
        titleBarBuilder.setTitleText("设置");
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.tv_about})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_about://登录成功
                ActivityUtils.startActivity(this,AboutActivity.class);
                break;
            default:
                break;

        }
    }


}
