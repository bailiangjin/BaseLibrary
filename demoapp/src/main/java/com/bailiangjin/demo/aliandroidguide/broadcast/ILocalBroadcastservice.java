package com.bailiangjin.demo.aliandroidguide.broadcast;

import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;

/**
 * TODD:添加类注释
 *
 * @author bailiangjin
 * @date 2018/3/6
 */

public interface ILocalBroadcastservice {


    /**
     * 获取 LocalBroadcastManager
     * @param appContext app全局上下文
     * @return
     */
    LocalBroadcastManager getLocalBroadcastManager(Context appContext);
}
