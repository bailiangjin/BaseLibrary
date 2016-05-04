package com.kevin.building;

import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.app.AppUtils;
import com.kevin.baselibrary.config.CleanOptions;
import com.kevin.baselibrary.utils.CleanUtils;
import com.kevin.building.activity.LoginActivity;
import com.kevin.building.activity.TestActivity;
import com.kevin.building.base.BtnBaseActivity;
import com.kevin.building.demo.WebViewActivity;
import com.kevin.building.demo.fragmentdemo.MyFragmentActivity;
import com.kevin.building.demo.networkdemo.NetworkActivity;
import com.kevin.building.demo.viewpager.ViewPagerDemoActivity;
import com.kevin.building.demo.widget.WidgetMainActivity;
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
//        btn6.setText("ViewPagerDemo");
        btn6.setText("ViewPagerDemo");
        btn7.setText("测试WebView");
        btn8.setText("测试文件监听");


        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);
        btn7.setVisibility(View.VISIBLE);
        btn8.setVisibility(View.VISIBLE);
//        NdkJniUtils jni = new NdkJniUtils();
//        shortToast("jni:" + jni.getCLanguageString());

//        shortToast(ConfigUtils.getValueByKey("testkey"));
    }

    @Override
    protected void initLogic() {
        //建造者模式 设置应用启动时的清理项
        CleanOptions cleanOptions = new CleanOptions.Builder()
                .cleanRootDir(false)
                .cleanDBDir(true)
                .cleanMediaDir(false)
                .cleanOtherDir(false).build();
        //按设置清理应用目录
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
                ActivityUtils.startActivity(this, NetworkActivity.class);
                break;

            case R.id.btn4:
                ActivityUtils.startDatabaseActivity(MainActivity.this);
                break;

            case R.id.btn5:
                ActivityUtils.startActivity(this, MyFragmentActivity.class);
                break;

            case R.id.btn6:
                //shortToast("点击了测试6");
                ActivityUtils.startActivity(this, ViewPagerDemoActivity.class);
//                ActivityUtils.startActivity(this, SwitchNetWorkStateActivity.class);
                break;

            case R.id.btn7:
                ActivityUtils.startActivity(this, WebViewActivity.class);
                break;

            case R.id.btn8:
//               shortToast("点击了当前测试");
                ActivityUtils.startActivity(this, TestActivity.class);

//                AppUtils.startAnyApp("com.xywy.flydoctor");
//                AppUtils.unInstallApp("com.xywy.flydoctor");
                break;


            default:
                break;
        }

    }

    @Override
    protected void handleMsg(Message msg) {

    }

    @Override
    public void onBackPressed() {
        //再点一次退出应用
        if (AppUtils.oneMoreClickExitApp(MainActivity.this)) {
          //不退出应用 打出提示
        } else {
            //TODO:添加退出应用相关逻辑
            super.onBackPressed();
        }
    }
}
