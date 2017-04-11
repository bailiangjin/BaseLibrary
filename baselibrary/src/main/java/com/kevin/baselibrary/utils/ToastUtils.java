package com.kevin.baselibrary.utils;

import android.content.Context;
import android.widget.Toast;

import com.kevin.baselibrary.api.UtilsLibrary;

/**
 * Toast 工具类
 *
 * 使用自定义Toast类 防止多次点击重复生成多个Toast 长时间显示问题
 *
 * @author blj
 */
public class ToastUtils {

    /**
     * 短提示 by resId
     *
     * @param resId
     */
    public static void shortToast(int resId) {
        toastResId( resId, Toast.LENGTH_SHORT);
    }

    /**
     * 短提示 by String
     *
     * @param string
     */
    public static void shortToast(String string) {
        toastString(string, Toast.LENGTH_SHORT);
    }

    /**
     * 长提示 by resId
     *
     * @param resId
     */
    public static void longToast(int resId) {
        toastResId(resId, Toast.LENGTH_LONG);
    }

    /**
     * 常提示 by String
     *
     * @param string
     */
    public static void longToast(String string) {
        toastString(string, Toast.LENGTH_LONG);
    }

    /**
     * 判断时间间隔提示Toast by String
     *
     * @param str      文字
     * @param showTime
     */
    private static void toastString(String str, int showTime) {
        MyToast.getToast(UtilsLibrary.getAppContext(), str, showTime).show();
    }

    /**
     * 判断时间间隔提示Toast by resId
     * @param resId
     * @param showTime
     */
    private static void toastResId(int resId, int showTime) {
        MyToast.getToast(UtilsLibrary.getAppContext(), UtilsLibrary.getAppContext().getString(resId), showTime).show();
    }

    /**
     * 自定义Toast类
     *
     * @author blj
     */
    static class MyToast {
        private static Context context = null;
        private static Toast toast = null;

        public static Toast getToast(Context context, String words, int showTime) {
            if (MyToast.context == context) {
                toast.setText(words);
                toast.setDuration(showTime);
            } else {
                MyToast.context = context;
                toast = Toast.makeText(context, words, showTime);
            }
            return toast;
        }
    }

}
