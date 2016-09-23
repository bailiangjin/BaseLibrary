package com.kevin.baselibrary.utils.device;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.nfc.NfcManager;
import android.provider.Settings;

import com.kevin.baselibrary.app.AppUtils;

/**
 * Created by bailiangjin on 16/9/23.
 */

public class GPSUtils {

    PackageManager pm = AppUtils.getContext().getPackageManager();
    // 获取是否支持电话
    boolean telephony = pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
    // 是否支持GSM
    boolean gsm = pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_GSM);
    // 是否支持CDMA
    boolean cdma = pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_CDMA);
    /*
     * 使用hasSystemFeature方法可以检查设备是否其他功能。如陀螺仪，NFC，蓝牙等等，
     */
    boolean nfc = pm.hasSystemFeature(PackageManager.FEATURE_NFC);



//    public static boolean enableNFC() {
//        NfcManager nfcManager = (NfcManager) AppUtils.getContext()
//                .getSystemService(Context.NFC_SERVICE);
//        return nfcManager.getDefaultAdapter();
//    }

    public static boolean isNFCpen() {
        NfcManager nfcManager = (NfcManager) AppUtils.getContext()
                .getSystemService(Context.NFC_SERVICE);
        return nfcManager.getDefaultAdapter().isEnabled();
    }


    public static boolean isGPSOpen() {
        LocationManager locationManager = (LocationManager) AppUtils.getContext()
                .getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static void changeGpsState() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            AppUtils.getContext().startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            // The Android SDK doc says that the location settings activity
            // may not be found. In that case show the general settings.
            // General settings activity
            intent.setAction(Settings.ACTION_SETTINGS);
            try {
                AppUtils.getContext().startActivity(intent);
            } catch (Exception e) {
            }
        }
    }

}
