package com.kevin.baselibrary.utils.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

import com.kevin.baselibrary.utils.LogUtils;

import java.util.List;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/10/15 00:20
 */
public class LifecycleUtils {

    /**
     * //判断 last TaskId 不为-1 并且 不等于当前taskId 切换到之前 task 否则 销毁activity
     *
     * @param activity
     * @param lastTaskId
     */
    @SuppressLint("NewApi")
    public static void onBackPressedToLastTask(Activity activity, int lastTaskId) {
        //获取当前activity taskId
        int curTaskId = activity.getTaskId();

        ActivityManager mActivityManager = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfoList = mActivityManager.getRunningTasks(100);
        boolean isLastTaskRunning = isTaskRunning(lastTaskId);

        if (isLastTaskRunning && -1 != lastTaskId && lastTaskId != curTaskId) {
            LogUtils.e("onBack:toLastTask");


            mActivityManager.moveTaskToFront(lastTaskId, ActivityManager.MOVE_TASK_WITH_HOME);
        } else {
            LogUtils.e("onBack:finishActivity");
            activity.finish();
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void moveTaskToFront(int taskId){
        ActivityManager mActivityManager = (ActivityManager) AppUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfoList = mActivityManager.getRunningTasks(100);
        boolean isLastTaskRunning = isTaskRunning(taskId);
        if (isLastTaskRunning){
            mActivityManager.moveTaskToFront(taskId, ActivityManager.MOVE_TASK_WITH_HOME);
            LogUtils.e("moveTaskToFront:taskId:"+taskId);
        }else {
            LogUtils.e("moveTaskToFront:taskNotRunning");
        }

    }

    /**
     * 判断Tsak 是否在运行中
     *
     * @param taskId
     * @return
     */
    public static boolean isTaskRunning(int taskId) {
        ActivityManager mActivityManager = (ActivityManager) AppUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfoList = mActivityManager.getRunningTasks(100);
        boolean lastTaskRunning = false;
        for (ActivityManager.RunningTaskInfo info : runningTaskInfoList) {
            if (info.id == taskId) {
                lastTaskRunning = true;
            }
        }
        return lastTaskRunning;
    }

    /**
     * 将当前activity 所属task切到后台
     *
     * @return
     */
    public static void moveTaskToBack(Activity activity) {
        activity.moveTaskToBack(true);
    }
}
