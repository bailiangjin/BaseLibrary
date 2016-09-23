package com.kevin.baselibrary.utils.device;

import android.content.pm.PackageManager;

import com.kevin.baselibrary.app.AppUtils;

/**
 * 设备检测工具类
 * Created by bailiangjin on 16/9/23.
 */

public class DeviceCheckUtils {


    public static boolean isSupportLocationByNetWork() {
        PackageManager pm = AppUtils.getContext().getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_LOCATION_NETWORK);
    }

    public static boolean isSupportGps() {
        PackageManager pm = AppUtils.getContext().getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
    }

    public static boolean isSupportLocation() {
        PackageManager pm = AppUtils.getContext().getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_LOCATION);
    }


    public static boolean isSupportBluetoothLE() {
        PackageManager pm = AppUtils.getContext().getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE);
    }


    public static boolean isSupportBluetooth() {
        PackageManager pm = AppUtils.getContext().getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH);
    }


    public static boolean isSupportTelephony() {
        PackageManager pm = AppUtils.getContext().getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
    }

    public static boolean isSupportGsm() {
        PackageManager pm = AppUtils.getContext().getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_GSM);
    }

    public static boolean isSupportCdma() {
        PackageManager pm = AppUtils.getContext().getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_CDMA);
    }

    public static boolean isSupportNFC() {
        PackageManager pm = AppUtils.getContext().getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_NFC);
    }
}
