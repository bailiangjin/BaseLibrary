package com.bailiangjin.utilslibrary.api;

import android.app.Application;
import android.content.Context;

import com.bailiangjin.utilslibrary.utils.ui.ImageLoadUtils;

/**
 * Created by bailiangjin on 2017/4/10.
 */

public class UtilsLibrary {

    public static ApiConfig apiConfig;

    public static void init(Application application) {
        apiConfig = new ApiConfig(application);
        onInit(application);
    }

    private static void onInit(Application application) {
        ImageLoadUtils.INSTANCE.init(application);
    }

    public static Context getAppContext(){
        checkInit();
        return apiConfig.getApplication().getApplicationContext();
    }

    private static void checkInit() {
        if(null==apiConfig){
            throw new RuntimeException("please call UtilsLibrary.init() first");
        }
    }
}
