package com.bailiangjin.simpleim.appui.account;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.bailiangjin.simpleim.IMApplication;
import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.base.BaseActivity;


public class LogoutActivity extends BaseActivity {

    private Button btn_set_manageuser;
    private Button btn_set_cancel;
    private Button btn_set_logout;

    public static void start(Activity activity){
        Intent intent = new Intent(activity,LogoutActivity.class);
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
    protected void initView() {
        titleBarBuilder.setTitleText(getString(R.string.logout));
        btn_set_manageuser = (Button) findViewById(R.id.btn_set_manageuser);
        btn_set_cancel = (Button) findViewById(R.id.btn_set_cancel);
        btn_set_logout = (Button) findViewById(R.id.btn_set_logout);
        btn_set_manageuser.setOnClickListener(this);
        btn_set_cancel.setOnClickListener(this);
        btn_set_logout.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void onViewClick(View v) {
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
