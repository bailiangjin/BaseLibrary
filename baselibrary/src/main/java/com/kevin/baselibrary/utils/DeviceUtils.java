package com.kevin.baselibrary.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.kevin.baselibrary.app.SuperBaseApplication;

/**
 * 设备相关工具类
 *
 * @author bailiangjin
 */
public class DeviceUtils {

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getDevicModel() {
        return android.os.Build.MODEL;
    }

    public static String getDevicBrand() {
        return android.os.Build.BRAND;
    }


    /**
     * 获取Imei
     *
     * @return
     */
    public static String getIMei() {

        return getIMei(SuperBaseApplication.getContext());
    }

    /**
     * 获取Imei
     *
     * @param context
     * @return
     */
    private static String getIMei(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String imei = telephonyManager.getDeviceId();
            return imei;
        } catch (Exception e) {
            return "0000000000";
        }
    }

    /**
     * 获取手机系统版本
     *
     * @param context
     * @return
     */
    public static String getMobileOSVersion(Context context) {
        try {
            String release = android.os.Build.VERSION.RELEASE; // android系统版本号
            return release;
        } catch (Exception e) {
            return "未知";
        }
    }


}
