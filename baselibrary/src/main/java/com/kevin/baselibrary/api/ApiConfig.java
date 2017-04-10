package com.kevin.baselibrary.api;

import android.app.Application;

/**
 * Created by bailiangjin on 2017/4/10.
 */

public class ApiConfig {

    private Application application;


    public ApiConfig(Application application) {
        this.application = application;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

}
