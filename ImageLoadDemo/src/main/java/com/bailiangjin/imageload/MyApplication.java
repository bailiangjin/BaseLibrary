package com.bailiangjin.imageload;

import android.app.Application;

/**
 * Created by bailiangjin on 16/7/16.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoadUtils.INSTANCE.init(this);
    }





}
