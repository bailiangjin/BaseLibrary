package com.kevin.baselibrary.net;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.kevin.baselibrary.app.SuperApplication;
import com.kevin.baselibrary.enums.NetworkTypeEnum;
import com.kevin.baselibrary.enums.ProviderTypeEnum;
import com.kevin.baselibrary.utils.LogUtils;

public class NetUtils {

    private static String macAddr;

    /**
     * 当前手机是否有可用网络 (所有网络类型)
     *
     * @param context
     * @return
     */
    public static boolean isConnect(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // 获取网络连接管理的对象
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {

                    // 判断当前网络是否已经连接
                    if (info.getState() == NetworkInfo.State.CONNECTED) {

                        if (info.isAvailable()) {

                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.e("error" + e.toString());
        }
        return false;
    }

    /**
     * 当前 环境是否wifi已连接
     *
     * @param context
     * @return
     */
    public static boolean isWifiConnect(Context context) {
        // 获取手机所有连接管理对象
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
                // 如果当前手机没有任何网络连接时,networkInfo == null
                if (null != networkInfo) {
                    return "wifi".equalsIgnoreCase(networkInfo.getTypeName());
                }
            }
        } catch (Exception e) {
            LogUtils.e("error" + e.toString());
        }
        return false;
    }

    /**
     * 获取 wifi 信号强度
     *
     * @param context
     * @return
     */
    public static int getWifiRssi(Context context) {
        WifiManager mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
        int wifi = wifiInfo.getRssi(); // 取 wifi 信号强度
        return wifi;
    }

    public static String int2ip(long ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 0xFF).append(".");
        sb.append((ipInt >> 8) & 0xFF).append(".");
        sb.append((ipInt >> 16) & 0xFF).append(".");
        sb.append((ipInt >> 24) & 0xFF);
        return sb.toString();
    }

    // 在wifi未开启状态下，仍然可以获取MAC地址，但是IP地址必须在已连接状态下否则为0
    public static String getMacAddress(Activity activity) {
        if (macAddr.equals("")) {
            String macAddress = null, ip = null;
            WifiManager wifiManager = (WifiManager) activity.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = (null == wifiManager ? null : wifiManager.getConnectionInfo());
            if (null != info) {
                macAddress = info.getMacAddress();
                ip = int2ip(info.getIpAddress());
            }
            macAddr = macAddress;
            return macAddress;
        } else {
            return macAddr;
        }
    }


    /**
     * 获取运营商类型
     *
     * @return ProviderTypeEnum 运营商类型
     */
    public static ProviderTypeEnum getProviderType() {
        TelephonyManager telephonyManager = (TelephonyManager) SuperApplication.getContext().getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
        String imsi; // 返回唯一的用户ID;就是这张卡的编号神马的
        imsi = telephonyManager.getSubscriberId();
        String type= telephonyManager.getSimOperator();
        LogUtils.e("mytype:getSubscriberId:"+imsi);
        LogUtils.e("mytype:getSimOperator:"+type);

        if (imsi == null) {
            return ProviderTypeEnum.UNKNOWN;
        }

        //MSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信
        if (imsi.startsWith("46000") || imsi.startsWith("46002")) {
            return ProviderTypeEnum.CHINA_MOBILE;
        } else if (imsi.startsWith("46001")) {
            return ProviderTypeEnum.CHINA_UNICOM;
        } else if (imsi.startsWith("46003")) {
            return ProviderTypeEnum.CHINA_NET;
        }

        return ProviderTypeEnum.UNKNOWN;
    }


    /**
     * 获取网络类型
     *
     * @return
     */
    public static NetworkTypeEnum getNetWorkType() {
        NetworkInfo networkInfo = ((ConnectivityManager) SuperApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return NetworkTypeEnum.TYPE_WIFI;
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                String _strSubTypeName = networkInfo.getSubtypeName();

                Log.e("cocos2d-x", "Network getSubtypeName : " + _strSubTypeName);

                // TD-SCDMA   networkType is 17
                int networkType = networkInfo.getSubtype();
                switch (networkType) {
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                    case TelephonyManager.NETWORK_TYPE_IDEN: //api<8 : replace by 11
                        return NetworkTypeEnum.TYPE_2G;
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_B: //api<9 : replace by 14
                    case TelephonyManager.NETWORK_TYPE_EHRPD:  //api<11 : replace by 12
                    case TelephonyManager.NETWORK_TYPE_HSPAP:  //api<13 : replace by 15
                        return NetworkTypeEnum.TYPE_3G;
                    case TelephonyManager.NETWORK_TYPE_LTE:    //api<11 : replace by 13
                        return NetworkTypeEnum.TYPE_4G;
                    default:
                        if (_strSubTypeName.equalsIgnoreCase("TD-SCDMA")
                                || _strSubTypeName.equalsIgnoreCase("WCDMA")
                                || _strSubTypeName.equalsIgnoreCase("CDMA2000")) {
                            return NetworkTypeEnum.TYPE_3G;
                        }
                        break;
                }

            }
        }
        return NetworkTypeEnum.UNKNOWN;
    }


    /**
     * 判断是否需要加载较少数据
     *
     * @return
     */
    public static boolean isSmallDataNeeded() {
        NetworkTypeEnum networkType = getNetWorkType();
        if (NetworkTypeEnum.TYPE_2G == networkType || NetworkTypeEnum.UNKNOWN == networkType) {
            return true;
        } else if (NetworkTypeEnum.TYPE_3G == networkType) {
            ProviderTypeEnum providerType = getProviderType();
            if (ProviderTypeEnum.CHINA_MOBILE == providerType || ProviderTypeEnum.UNKNOWN == providerType) {
                return true;
            }
        }
        return false;
    }

}
