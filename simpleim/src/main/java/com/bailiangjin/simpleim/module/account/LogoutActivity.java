package com.bailiangjin.simpleim.module.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bailiangjin.simpleim.IMApplication;
import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.appcommon.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class LogoutActivity extends BaseActivity {

    @BindView(R.id.btn_set_manageuser)
    Button btn_set_manageuser;
    @BindView(R.id.btn_set_cancel)
    Button btn_set_cancel;
    @BindView(R.id.btn_set_logout)
    Button btn_set_logout;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, LogoutActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_logout;
    }

    @Override
    protected void initIntentData() {

    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        titleBarBuilder.setTitleText(getString(R.string.logout));
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @OnClick({R.id.btn_set_cancel, R.id.btn_set_logout, R.id.btn_set_manageuser})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_set_cancel:
                this.finish();
                break;
            case R.id.btn_set_logout:
                // 用户登出逻辑添加
                //Activity登出
                IMApplication.getInstance().appExit();
                //打开登录页
                LoginActivity.start(LogoutActivity.this);
                this.finish();
                break;
            case R.id.btn_set_manageuser:
                // TODO:用户管理逻辑添加
                break;

            default:
                break;
        }

    }

}
