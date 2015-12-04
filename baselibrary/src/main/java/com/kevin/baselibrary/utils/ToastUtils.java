package com.kevin.baselibrary.utils;

import android.content.Context;
import android.widget.Toast;

import com.kevin.baselibrary.app.SuperApplication;

/**
 * Toast 工具类
 *
 * 使用自定义Toast类 防止多次点击重复生成多个Toast 长时间显示问题
 *
 * @author blj
 */
public class ToastUtils {

    public static void show(int resId) {
        shortShow(SuperApplication.getContext(), resId);
    }
    public static void show(String  str) {
        shortShow(SuperApplication.getContext(), str);
    }

    /**
     * 短提示 by resId
     *
     * @param context
     * @param resId
     */
    public static void shortShow(Context context, int resId) {
        showResId(context, resId, Toast.LENGTH_SHORT);
    }

    /**
     * 长提示 by resId
     *
     * @param context
     * @param resId
     */
    public static void longShow(Context context, int resId) {
        showResId(context, resId, Toast.LENGTH_LONG);
    }

    /**
     * 短提示 by String
     *
     * @param context
     * @param string
     */
    public static void shortShow(Context context, String string) {
        showString(context, string, Toast.LENGTH_SHORT);
    }

    /**
     * 常提示 by String
     *
     * @param context
     * @param string
     */
    public static void longShow(Context context, String string) {
        showString(context, string, Toast.LENGTH_LONG);
    }

    /**
     * 判断时间间隔提示Toast by String
     *
     * @param context
     * @param str      文字
     * @param showTime
     */
    private static void showString(Context context, String str, int showTime) {
        MyToast.getToast(context, str, showTime).show();
    }

    /**
     * 判断时间间隔提示Toast by resId
     *
     * @param context
     * @param resId
     * @param showTime
     */
    private static void showResId(Context context, int resId, int showTime) {
        MyToast.getToast(context, context.getString(resId), showTime).show();
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
