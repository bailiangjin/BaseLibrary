package com.kevin.baselibrary.utils.app;

import android.content.Context;

/**
 * Context(上下文)工具类
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/9/28 15:01
 */
public class CtxtUtils {

    /**
     * 全局 根据id获取string 字段方法
     * @param resId
     * @return
     */
    public static String getString(int resId) {
        Context context = AppUtils.getContext();
        return context.getString(resId);
    }
}
