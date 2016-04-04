package com.kevin.baselibrary.interfaze.listener;

import android.os.FileObserver;
import android.util.Log;

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
            case FileObserver.ALL_EVENTS:
                Log.d("all", "path:" + path);
                break;
            case FileObserver.CREATE:
                Log.d("Create", "path:"+ path);
                break;
        }
    }
}

