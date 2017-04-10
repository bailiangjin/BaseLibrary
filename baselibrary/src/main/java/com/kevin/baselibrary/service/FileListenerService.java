package com.kevin.baselibrary.service;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.kevin.baselibrary.base.SuperBaseService;
import com.kevin.baselibrary.interfaze.listener.IFileListener;
import com.kevin.baselibrary.tools.MultiFileObserver;
import com.kevin.baselibrary.utils.file.FilePathUtil;
import com.kevin.baselibrary.utils.LogUtils;

/**
 * Created by bailiangjin on 16/4/5.
 */
public class FileListenerService extends SuperBaseService {

//    private SDCardListener sdCardListener;
    private MultiFileObserver multiFileObserver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();

//        if (null == sdCardListener) {
//            sdCardListener = new SDCardListener(FilePathUtil.getAppPath() + "/");
//            sdCardListener.startWatching(); //开始监听
//            LogUtils.e("开始文件监听:service");
//        }

        if(null == multiFileObserver) {
            multiFileObserver = new MultiFileObserver(FilePathUtil.getSdcardPath() + "/", new IFileListener() {
                @Override
                public void onCreate(String filePath) {
                    LogUtils.e("创建:"+filePath);
                }

                @Override
                public void onModify(String filePath) {
                    LogUtils.e("修改:"+filePath);
                }

                @Override
                public void onDelete(String filePath) {
                    LogUtils.e("删除:"+filePath);

                }

                @Override
                public void onRead(String filePath) {
                    LogUtils.e("读取:"+filePath);

                }

                @Override
                public void onWrite(String filePath) {
                    LogUtils.e("写文件:"+filePath);

                }

                @Override
                public void onOpen(String filePath) {
                    LogUtils.e("打开文件:"+filePath);
                }

                @Override
                public void onCloseWrite(String filePath) {
                    LogUtils.e("写文件关闭:"+filePath);
                }

                @Override
                public void onCloseNoWrite(String filePath) {
                    LogUtils.e("非写文件关闭:"+filePath);
                }
            });
            multiFileObserver.startWatching(); //开始监听
            LogUtils.e("开始文件目录监听:service");
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

//        if (null != sdCardListener) {
//            sdCardListener.stopWatching(); //停止监听
//        }

        if (null != multiFileObserver) {
            multiFileObserver.stopWatching(); //停止监听
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

}
