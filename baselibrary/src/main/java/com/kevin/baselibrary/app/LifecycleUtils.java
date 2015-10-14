package com.kevin.baselibrary.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import com.kevin.baselibrary.utils.LogUtils;

import java.util.List;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/10/15 00:20
 */
public class LifecycleUtils {

    /**
     * //判断 last TaskId 不为-1 并且 不等于当前taskId 切换到之前 task 否则 销毁activity
     * @param activity
     * @param lastTaskId
     */
    @SuppressLint("NewApi")
    public static void onBackPressedToLastTask(Activity activity, int lastTaskId) {
        //获取当前activity taskId
        int curTaskId= activity.getTaskId();

        ActivityManager mActivityManager = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfoList= mActivityManager.getRunningTasks(100);
        boolean isLastTaskRunning = isTaskRunning(lastTaskId);

        if (isLastTaskRunning&&-1!=lastTaskId&&lastTaskId!=curTaskId){
            LogUtils.e("onBack:toLastTask");


            mActivityManager.moveTaskToFront(lastTaskId, ActivityManager.MOVE_TASK_WITH_HOME);
        }else {
            LogUtils.e("onBack:finishActivity");
            activity.finish();
        }
    }

    /**
     * 判断Tsak 是否在运行中
     * @param taskId
     * @return
     */
    public static boolean isTaskRunning( int taskId){
        ActivityManager mActivityManager = (ActivityManager) AppUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfoList= mActivityManager.getRunningTasks(100);
        boolean lastTaskRunning = false;
        for (ActivityManager.RunningTaskInfo info:runningTaskInfoList) {
            if(info.id==taskId){
                lastTaskRunning = true;
            }
        }
        return lastTaskRunning;
    }
}
