package com.kevin.baselibrary.utils.file;

import com.kevin.baselibrary.app.AppUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/26 15:40
 */
public class ResUtils {

    public static String getString(int resId) {
        return AppUtils.getContext().getString(resId);
    }
}
