package com.kevin.building.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.kevin.building.R;
import com.kevin.building.activity.logicutils.AccountUtils;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BaseActivity;

public class LogoutActivity extends BaseActivity {

    private Button btn_set_manageuser;
    private Button btn_set_cancel;
    private Button btn_set_logout;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_logout;
    }


    @Override
    protected void initView() {
        commonTitleView.setTitleText(getString(R.string.logout));
        commonTitleView.setRightBtnVisibility(View.GONE);
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
    protected void handleMsg(Message msg) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.btn_set_cancel:
                this.finish();
                break;
            case R.id.btn_set_logout:
                // 用户登出逻辑添加
                AccountUtils.logout();
                //Activity登出
                AppManager.getInstance().logout();
                //打开登录页
                Intent intent = new Intent(this, LoginActivity.class);
                AppManager.getInstance().startActivity(LogoutActivity.this, intent);
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
