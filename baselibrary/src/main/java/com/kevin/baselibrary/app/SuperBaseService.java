package com.kevin.baselibrary.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.kevin.baselibrary.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by bailiangjin on 16/4/5.
 */
public class SuperBaseService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //注册EventBus
        EventBus.getDefault().register(this);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        //取消注册EventBus
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


    //其他方法
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(Object obj) {
        onMyEvent(obj);
    }

    /**
     * Event bus 事件分发 供子类覆盖
     * @param obj
     */
    protected void onMyEvent(Object obj) {
        LogUtils.d("事件分发：" + obj.toString());
    }

}
