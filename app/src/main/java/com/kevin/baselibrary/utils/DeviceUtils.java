package com.kevin.baselibrary.utils;

/**
 * 设备相关工具类
 * @author bailiangjin
 *
 */
public class DeviceUtils
{

	/**
	 * 获取手机型号
	 * 
	 * @return
	 */
	public static String getDevicModel()
	{
		return android.os.Build.MODEL;
	}
}
