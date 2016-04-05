package com.kevin.building.demo.filelistener;

import android.app.Service;
import android.content.Intent;
import android.os.FileObserver;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.kevin.baselibrary.interfaze.listener.SDCardListener;
import com.kevin.baselibrary.utils.FilePathUtil;
import com.kevin.baselibrary.utils.LogUtils;

/**
 * Created by bailiangjin on 16/4/5.
 */
public class FileListenerService  extends Service{

    private SDCardListener mFileObserver;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        if(null == mFileObserver) {
            mFileObserver = new SDCardListener(FilePathUtil.getAppPath()+"/", FileObserver.ALL_EVENTS);
            mFileObserver.startWatching(); //开始监听
            LogUtils.e("开始文件监听:service");
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(null != mFileObserver){
            mFileObserver.stopWatching(); //停止监听
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

}
