package com.bailiangjin.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.bailiangjin.demo.activity.TestActivity;
import com.bailiangjin.demo.base.BtnBaseActivity;
import com.bailiangjin.demo.demo.X5WebViewActivity;
import com.bailiangjin.demo.demo.file.FileOperationActivity;
import com.bailiangjin.demo.demo.fragmentdemo.MyFragmentActivity;
import com.bailiangjin.demo.demo.networkdemo.NetworkActivity;
import com.bailiangjin.demo.demo.viewpager.ViewPagerDemoActivity;
import com.bailiangjin.demo.demo.widget.WidgetMainActivity;
import com.bailiangjin.demo.utils.ActivityUtils;
import com.bailiangjin.utilslibrary.utils.app.AppUtils;
import com.bailiangjin.utilslibrary.utils.file.CleanOptions;
import com.bailiangjin.utilslibrary.utils.file.CleanUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/20 10:40
 */
public class MainActivity extends BtnBaseActivity {


    public static void start(Activity activity){
        Intent intent = new Intent(activity,MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_btn_base;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        titleBarBuilder.setTitleText("首页");
        titleBarBuilder.hideBackIcon();

        btn1.setText("控件模块");
        btn2.setText("AppStyle");
        btn3.setText("网络模块");
        btn4.setText("数据库模块");
        btn5.setText("Fragment模块");
        btn6.setText("ViewPagerDemo");
        btn7.setText("测试WebView");
        btn8.setText("文件操作");


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
    protected void initData(Bundle savedInstanceState) {
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
//                ActivityUtils.startActivity(this, LoginActivity.class);
                TestActivity.start(this);

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
                shortToast("点击了测试6");
                ActivityUtils.startActivity(this, ViewPagerDemoActivity.class);
//                ActivityUtils.startActivity(this, SwitchNetWorkStateActivity.class);
                break;

            case R.id.btn7:
                ActivityUtils.startActivity(this, X5WebViewActivity.class);
                break;

            case R.id.btn8:
//               shortToast("点击了当前测试");
                ActivityUtils.startActivity(this, FileOperationActivity.class);

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
