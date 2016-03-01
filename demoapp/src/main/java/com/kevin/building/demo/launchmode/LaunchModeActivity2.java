package com.kevin.building.demo.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import com.kevin.baselibrary.utils.java.LogUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/14 13:58
 */
public class LaunchModeActivity2 extends LaunchModeActivity1 {
//    private int lastTaskId = -1;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.e("onNewIntent:test");
        LogUtils.e("taskId:" + getLocalClassName() + ":" + getTaskId());
        show("onNewIntent");
//        lastTaskId = getIntent().getIntExtra("lastTaskId", -1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show("onCreate");
//        lastTaskId = getIntent().getIntExtra("lastTaskId", -1);
    }

    @Override
    protected void onRestart() {

        super.onRestart();

    }

    @Override
    protected void onStart() {
//        if(!LifecycleUtils.isTaskRunning(lastTaskId)){
//            finish();
//        }

        super.onStart();
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void initView() {
        super.initView();
        titleView.setTitleText("Activity2");
    }


    @Override
    protected void handleMsg(Message msg) {

    }

    @Override
    public void onBackPressed() {
//        LifecycleUtils.onBackPressedToLastTask(LaunchModeActivity2.this, lastTaskId);
        moveTaskToBack(true);

    }


}
