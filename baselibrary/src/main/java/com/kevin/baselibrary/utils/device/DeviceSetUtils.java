package com.kevin.baselibrary.utils.device;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.provider.Settings;

import com.kevin.baselibrary.app.AppUtils;

/**
 * Created by bailiangjin on 16/9/23.
 */

public class DeviceSetUtils {


    public static void toSetMain(){
        toSetByAction(Settings.ACTION_SETTINGS);
    }

    public static void toSetWiFi(){
        toSetByAction(Settings.ACTION_WIFI_SETTINGS);
    }

    public static void toSetWireless(){
        toSetByAction(Settings.ACTION_WIRELESS_SETTINGS);
    }

    public static void toSetBluetooth(){
        toSetByAction(Settings.ACTION_BLUETOOTH_SETTINGS);
    }

    public static void toSetNetworkOperator(){
        toSetByAction(Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
    }

    public static void toSetRoaming(){
        toSetByAction(Settings.ACTION_DATA_ROAMING_SETTINGS);
    }



    public static void toSetByAction(String action) {
        Intent intent = new Intent(action);
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
