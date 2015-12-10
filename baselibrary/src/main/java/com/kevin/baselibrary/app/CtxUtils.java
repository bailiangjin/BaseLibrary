package com.kevin.baselibrary.app;

import android.content.Context;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/9/28 15:01
 */
public class CtxUtils {

    /**
     * getString by res id
     * @param id
     * @return
     */
    public static String getString(int id) {
        Context context = AppUtils.getContext();
        return context.getString(id);
    }
}
