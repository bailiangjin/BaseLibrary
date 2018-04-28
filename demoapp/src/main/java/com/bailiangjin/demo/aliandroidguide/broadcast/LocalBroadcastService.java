package com.bailiangjin.demo.aliandroidguide.broadcast;

import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;

/**
 * TODD:添加类注释
 *
 * @author bailiangjin
 * @date 2018/3/6
 */

public class LocalBroadcastService implements ILocalBroadcastservice{


    @Override
    public LocalBroadcastManager getLocalBroadcastManager(Context appContext) {
        LocalBroadcastManager localBroadcastManager=getLocalBroadcastManager(appContext);
        return localBroadcastManager;
    }
}
