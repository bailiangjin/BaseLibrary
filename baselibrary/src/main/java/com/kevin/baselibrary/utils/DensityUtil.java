package com.kevin.baselibrary.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;

/**
 * dp与px转换工具
 * 
 */
public class DensityUtil
{
	/**
	 * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue)
	{
		final float density = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * density + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(Context context, float pxValue)
	{
		final float density = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / density + 0.5f);
	}

	/**
	 * 从资源dimen 中获取尺寸值 当dimen 中定义值为dp 时 返回值为dp＊density 为转化后的实际px值
	 */
	public static int getDimension(Context context, int dimenId)
	{
		return (int) context.getResources().getDimension(dimenId);
	}

	public static int getPXFromString(Context context, String value)
	{
		String lowerValue = value.toLowerCase();

		if (lowerValue.endsWith("px"))
		{
			return Integer.parseInt(lowerValue.substring(0, lowerValue.indexOf("px")));
		}
		else if (lowerValue.endsWith("dp") || lowerValue.endsWith("dip"))
		{
			return dip2px(context, Integer.parseInt(lowerValue.substring(0, lowerValue.indexOf("d"))));
		}
		else if (lowerValue.matches("\\d+"))
		{
			return Integer.parseInt(lowerValue);
		}
		else
		{
			throw new RuntimeException("转换字符串不合法");
		}
	}


	/**
	 * 获取手机屏幕宽度
	 *
	 * @param activity
	 * @return
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static int getScreenWidth(Activity activity) {
		//获取手机系统版本号
		int deviceApiVersion = DeviceUtils.getCurrentApiVersion();
		DisplayMetrics dm = new DisplayMetrics();
		if (17 >= deviceApiVersion) {//获取没有虚拟按键的屏幕尺寸
			activity.getWindowManager().getDefaultDisplay().getRealMetrics(dm);
		} else {
			activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		}
		return  dm.widthPixels;
	}

	/**
	 * 获取手机屏高度
	 *
	 * @param activity
	 * @return
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static int getScreenheight(Activity activity) {
		//获取手机系统版本号
		int deviceApiVersion = DeviceUtils.getCurrentApiVersion();
		DisplayMetrics dm = new DisplayMetrics();
		if (17 >= deviceApiVersion) {//获取没有虚拟按键的屏幕尺寸
			activity.getWindowManager().getDefaultDisplay().getRealMetrics(dm);
		} else {
			activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		}
		return dm.heightPixels;
	}

}
