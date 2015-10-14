package com.kevin.building.activity.launchmode;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;

import com.kevin.baselibrary.utils.LogUtils;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/14 13:58
 */
public class LaunchModeActivity2 extends LaunchModeActivity1 {
    private int lastTaskId= -1;
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.e("onNewIntent:test");
        lastTaskId= getIntent().getIntExtra("lastTaskId",-1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lastTaskId= getIntent().getIntExtra("lastTaskId",-1);
    }

    @Override
    protected void initView() {
        super.initView();
        titleView.setTitleText("Activity2");
    }




    @Override
    protected void handleMsg(Message msg) {

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        int currentTaskId = getTaskId();
        LogUtils.e("curtaskId:" + currentTaskId);
        LogUtils.e("curtaskId:lastTaskId:" + lastTaskId);

        ActivityManager mActivityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE) ;

        List<ActivityManager.RunningTaskInfo> runList=  mActivityManager.getRunningTasks(100);
        for (ActivityManager.RunningTaskInfo info:runList) {

            LogUtils.e("curtaskId:item" + info.id);
            if (info.id==lastTaskId){
                LogUtils.e("curtaskId:find" + info.id);
            }

        }
        List<ActivityManager.AppTask> list= mActivityManager.getAppTasks();
        for (ActivityManager.AppTask task:list) {
            LogUtils.e("curtaskId:item" + currentTaskId);
            if (task.getTaskInfo().id==lastTaskId){

                task.moveToFront();
            }

        }
//        super.onBackPressed();


    }
}
