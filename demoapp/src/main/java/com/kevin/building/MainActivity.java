package com.kevin.building;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.app.AppUtils;
import com.kevin.baselibrary.config.ConfigUtils;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.building.activity.LoginActivity;
import com.kevin.building.activity.MyFragmentActivity;
import com.kevin.building.activity.RegistActivity;
import com.kevin.building.activity.UserInfoActivity;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.utils.ActivityUtils;

public class MainActivity extends BaseActivity {



    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        show("isPad:"+ AppUtils.isPad());

        show(ConfigUtils.getValueByKey("testkey"));
    }

    @Override
    protected void initView() {
        // titleView.setRightBtnVisibility(View.GONE);
        titleView.setTitleText(getString(R.string.index_page));
        titleView.setLeftBtnVisibility(View.GONE);
        titleView.setRightBtnText(getString(R.string.register));
        titleView.setRightButtonListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistActivity.class);

                AppManager.getInstance().startActivity(MainActivity.this, intent);

            }
        });
    }

    @Override
    protected void initLogic() {

    }


    public void onClick_btn_fragment(View v) {
        Intent intent = new Intent(this, MyFragmentActivity.class);
        AppManager.getInstance().startActivity(MainActivity.this, intent);
    }

    public void onClick_btn_test_db(View v) {
        ActivityUtils.startDatabaseActivity(MainActivity.this);
    }

    public void onClick_btn_test_login(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        AppManager.getInstance().startActivity(MainActivity.this, intent);
    }

    public void onClick_btn_test_user(View v) {
        Intent intent = new Intent(this, UserInfoActivity.class);
        AppManager.getInstance().startActivity(MainActivity.this, intent);
    }

    @Override
    public void onBackPressed() {
        //再点一次 退出应用
        AppUtils.oneMoreClickExitApp(this);

    }



    @Override
    public void onViewClick(View v) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void handleMsg(Message msg) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onHomePressed() {
        super.onHomePressed();
        LogUtils.e("submain:onHomePressed");
    }

    @Override
    protected void onHomeLongPressed() {
        super.onHomeLongPressed();
        LogUtils.e("submain:onHomeLongPressed");
    }
}
