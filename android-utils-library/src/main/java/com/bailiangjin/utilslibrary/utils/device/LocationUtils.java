package com.bailiangjin.utilslibrary.utils.device;

import android.content.Context;
import android.location.LocationManager;
import android.provider.Settings;

import com.bailiangjin.utilslibrary.utils.app.AppUtils;

/**
 * Created by bailiangjin on 16/9/23.
 */

public class LocationUtils {

    /**
     * 网络定位是否开启
     *
     * @return
     */
    public static boolean isNetworkOpen() {
        LocationManager locationManager = (LocationManager) AppUtils.getContext()
                .getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    /**
     * 被动定位是否开启
     *
     * @return
     */
    public static boolean isPassiveOpen() {
        LocationManager locationManager = (LocationManager) AppUtils.getContext()
                .getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.PASSIVE_PROVIDER);
    }


    /**
     * GPS 定位是否开启
     *
     * @return
     */
    public static boolean isGPSOpen() {
        LocationManager locationManager = (LocationManager) AppUtils.getContext()
                .getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }


    /**
     * 跳转到设置定位页
     * <p>
     * GPS/网络定位/高精度定位 切换
     */
    public static void toSetLocation() {
        String action = Settings.ACTION_LOCATION_SOURCE_SETTINGS;
        DeviceSetUtils.toSetByAction(action);
    }


}
