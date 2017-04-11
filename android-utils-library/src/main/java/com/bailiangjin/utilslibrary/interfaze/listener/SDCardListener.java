package com.bailiangjin.utilslibrary.interfaze.listener;

import android.os.FileObserver;

import com.bailiangjin.utilslibrary.utils.LogUtils;

/**
 * SD卡监听类
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：16/4/4 13:26
 */


public class SDCardListener extends FileObserver {

    public SDCardListener(String path) {
        /*
         * 这种构造方法是默认监听所有事件的,如果使用super(String,int)这种构造方法，
         * 则int参数是要监听的事件类型.
         */
        super(path);
    }

    public SDCardListener(String path, int mask) {
        super(path,mask);

    }


    @Override
    public void onEvent(int event, String path) {

        switch(event) {
            case FileObserver.ACCESS:
                LogUtils.e("文件监听:读文件");
                break;
            case FileObserver.ALL_EVENTS:

                LogUtils.e("文件监听:所有事件");
                break;
            case FileObserver.CREATE:
                LogUtils.e("文件监听:创建文件");
                break;
        }
    }
}

