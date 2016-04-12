package com.kevin.baselibrary.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by bailiangjin on 16/4/11.
 */
public abstract class AbsSuperApplication extends Application {

    protected static Context context;
    protected static String appName;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        appName =  getAppNameFromSub();
    }

    public static String getAppName() {
        return appName;
    }

    public static Context getContext() {
        return context;
    }

    protected abstract String  getAppNameFromSub();

}
