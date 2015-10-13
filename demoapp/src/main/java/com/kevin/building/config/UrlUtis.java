package com.kevin.building.config;

import com.kevin.building.R;
import com.kevin.building.app.MyApplication;


/**
 * Url Tools
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/9/22 17:46
 */
public class UrlUtis {


    /**
     * get collect base url
     *
     * @return
     */
    public static String getBaseUrl() {
        return MyApplication.getContext().getResources().getString(R.string.collectUrl);

    }

    /**
     * get H5 base url
     *
     * @return
     */
    public static String getBaseUrl2() {
        return MyApplication.getContext().getResources().getString(R.string.ccUrl);

    }



}
