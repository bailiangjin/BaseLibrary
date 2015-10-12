package com.kevin.baselibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class NetUtils
{

	private static String macAddr;

	/**
	 * 当前手机是否有可用网络 (所有网络类型)
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isConnect(Context context)
	{
		// 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
		try
		{
			ConnectivityManager connectivity = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null)
			{
				// 获取网络连接管理的对象
				NetworkInfo info = connectivity.getActiveNetworkInfo();
				if (info != null && info.isConnected())
				{

					// 判断当前网络是否已经连接
					if (info.getState() == NetworkInfo.State.CONNECTED)
					{

						if (info.isAvailable())
						{

							return true;
						}
					}
				}
			}
		}
		catch (Exception e)
		{
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
	public static boolean isWifiConnect(Context context)
	{
		// 获取手机所有连接管理对象
		try
		{
			ConnectivityManager connectivity = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null)
			{
				NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
				// 如果当前手机没有任何网络连接时,networkInfo == null
				if (null != networkInfo)
				{
					return "wifi".equalsIgnoreCase(networkInfo.getTypeName());
				}
			}
		}
		catch (Exception e)
		{
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
	public static int getWifiRssi(Context context)
	{
		WifiManager mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
		int wifi = wifiInfo.getRssi(); // 取 wifi 信号强度
		return wifi;
	}

	public static String int2ip(long ipInt)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(ipInt & 0xFF).append(".");
		sb.append((ipInt >> 8) & 0xFF).append(".");
		sb.append((ipInt >> 16) & 0xFF).append(".");
		sb.append((ipInt >> 24) & 0xFF);
		return sb.toString();
	}

	// 在wifi未开启状态下，仍然可以获取MAC地址，但是IP地址必须在已连接状态下否则为0
	public static String getMacAddress(Activity activity)
	{
		if (macAddr.equals(""))
		{
			String macAddress = null, ip = null;
			WifiManager wifiManager = (WifiManager) activity.getSystemService(Context.WIFI_SERVICE);
			WifiInfo info = (null == wifiManager ? null : wifiManager.getConnectionInfo());
			if (null != info)
			{
				macAddress = info.getMacAddress();
				ip = int2ip(info.getIpAddress());
			}
			macAddr = macAddress;
			return macAddress;
		}
		else
		{
			return macAddr;
		}
	}

}
