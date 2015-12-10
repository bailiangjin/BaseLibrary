package com.kevin.building;

import android.content.Intent;
import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.config.CleanOptions;
import com.kevin.baselibrary.config.ConfigUtils;
import com.kevin.baselibrary.instance.jni.NdkJniUtils;
import com.kevin.baselibrary.utils.CleanUtils;
import com.kevin.building.ui.activity.LoginActivity;
import com.kevin.building.ui.demo.fragmentdemo.MyFragmentActivity;
import com.kevin.building.ui.demo.networkdemo.NetworkActivity;
import com.kevin.building.ui.demo.widget.searchbar.SearchActivity;
import com.kevin.building.ui.demo.widget.WidgetMainActivity;
import com.kevin.building.ui.activity.UserInfoActivity;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BtnBaseActivity;
import com.kevin.building.ui.demo.launchmode.LaunchModeActivity1;
import com.kevin.building.utils.ActivityUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/20 10:40
 */
public class MainActivity extends BtnBaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_btn_base;
    }

    @Override
    protected void initView() {
        super.initView();

        titleView.setTitleText("主页面");
        titleView.setLeftBtnVisibility(View.GONE);

        btn1.setText("控件模块");
        btn2.setText("App流程模块");
        btn3.setText("网络模块");
        btn4.setText("数据库模块");
        btn5.setText("Fragment模块");
        btn6.setText("用户信息");
        btn7.setText("启动模式");
        btn8.setText("当前测试");

        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);
        btn7.setVisibility(View.VISIBLE);
        btn8.setVisibility(View.VISIBLE);
        NdkJniUtils jni = new NdkJniUtils();
        show("jni:" + jni.getCLanguageString());

        show(ConfigUtils.getValueByKey("testkey"));
    }

    @Override
    protected void initLogic() {

        CleanOptions cleanOptions = new CleanOptions.Builder()
                .cleanRootDir(false)
                .cleanDBDir(true)
                .cleanMediaDir(false)
                .cleanOtherDir(false).build();

        CleanUtils.cleanAppFileDirOnUpdate(cleanOptions);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                ActivityUtils.startActivity(this, WidgetMainActivity.class);
                break;

            case R.id.btn2:
                ActivityUtils.startActivity(this, LoginActivity.class);

                break;

            case R.id.btn3:
                Intent intent3 = new Intent(this, NetworkActivity.class);
                AppManager.getInstance().startActivity(MainActivity.this, intent3);
                break;

            case R.id.btn4:
                ActivityUtils.startDatabaseActivity(MainActivity.this);


                break;

            case R.id.btn5:
                Intent intent5 = new Intent(this, MyFragmentActivity.class);
                AppManager.getInstance().startActivity(MainActivity.this, intent5);

                break;

            case R.id.btn6:
                Intent intent = new Intent(this, UserInfoActivity.class);
                AppManager.getInstance().startActivity(MainActivity.this, intent);


                break;

            case R.id.btn7:
                Intent intent7 = new Intent(this, LaunchModeActivity1.class);
                AppManager.getInstance().startActivity(MainActivity.this, intent7);


                break;

            case R.id.btn8:
                ActivityUtils.startActivity(this, SearchActivity.class);


                break;


            default:
                break;
        }

    }

    @Override
    protected void handleMsg(Message msg) {

    }
}
