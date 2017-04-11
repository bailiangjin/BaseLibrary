package com.kevin.baselibrary.utils.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.kevin.baselibrary.api.UtilsLibrary;
import com.kevin.baselibrary.utils.device.DeviceInfoUtils;

/**
 * 获得屏幕相关的辅助类
 * 
 * @author zhy
 * 
 */
public class ScreenUtils
{
	private ScreenUtils()
	{
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}


	/**
	 * 获取手机屏幕显示宽度(实际显示宽度)
	 *
	 * @param activity
	 * @return
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static int getScreenWidth(Activity activity) {
		//获取手机系统版本号
		int deviceApiVersion = DeviceInfoUtils.getCurrentApiVersion();
		DisplayMetrics dm = new DisplayMetrics();
		if (17 >= deviceApiVersion) {//获取没有虚拟按键的屏幕尺寸
			activity.getWindowManager().getDefaultDisplay().getRealMetrics(dm);
		} else {
			activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		}
		return  dm.widthPixels;
	}

	/**
	 * 获取手机屏幕显示高度(实际显示高度 不包括虚拟按键部分)
	 *
	 * @param activity
	 * @return
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static int getScreenHeight(Activity activity) {
		//获取手机系统版本号
		int deviceApiVersion = DeviceInfoUtils.getCurrentApiVersion();
		DisplayMetrics dm = new DisplayMetrics();
		if (17 >= deviceApiVersion) {//获取没有虚拟按键的屏幕尺寸
			activity.getWindowManager().getDefaultDisplay().getRealMetrics(dm);
		} else {
			activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		}
		return dm.heightPixels;
	}

	/**
	 * 获得手机硬件屏幕高度(设备硬件高度 不依赖于页面)
	 * 
	 * @return
	 */
	public static int getDeviceScreenWidth()
	{

		return getDeviceScreenWidth(UtilsLibrary.getAppContext());
	}

	/**
	 * 获得硬件屏幕宽度(设备硬件高度 不依赖于页面)
	 * 
	 * @return
	 */
	public static int getDeviceScreenHeight()
	{
		return getDeviceScreenHeight(UtilsLibrary.getAppContext());
	}

	/**
	 * 获得状态栏的高度
	 * 
	 * @return
	 */
	public static int getStatusHeight()
	{

		return getStatusHeight(UtilsLibrary.getAppContext());
	}/**
	 * 获得屏幕高度
	 *
	 * @param context
	 * @return
	 */
	public static int getDeviceScreenWidth(Context context)
	{
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.widthPixels;
	}

	/**
	 * 获得屏幕宽度
	 *
	 * @param context
	 * @return
	 */
	public static int getDeviceScreenHeight(Context context)
	{
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.heightPixels;
	}

	/**
	 * 获得状态栏的高度
	 *
	 * @param context
	 * @return
	 */
	public static int getStatusHeight(Context context)
	{

		int statusHeight = -1;
		try
		{
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");
			Object object = clazz.newInstance();
			int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
			statusHeight = context.getResources().getDimensionPixelSize(height);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return statusHeight;
	}

	/**
	 * 获取当前屏幕截图，包含状态栏
	 * 
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithStatusBar(Activity activity)
	{
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		int width = getDeviceScreenWidth(activity);
		int height = getDeviceScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
		view.destroyDrawingCache();
		return bp;

	}

	/**
	 * 获取当前屏幕截图，不包含状状态栏
	 * 
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithoutStatusBar(Activity activity)
	{
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		Rect frame = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;

		int width = getDeviceScreenWidth(activity);
		int height = getDeviceScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight);
		view.destroyDrawingCache();
		return bp;

	}

}
