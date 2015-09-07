package com.kevin.baselibrary.utils;

import android.content.Context;

/**
 * 读取配置文件工具类 需要在assets目录下放置config.properties文件在其中写入键值对 格式：key=value
 * 
 * @author blj
 * 
 */
public class ConfigUtils
{

	/**
	 * 读取配置文件方法
	 * 
	 * @param context
	 * @param key
	 *            键
	 * @return value 值
	 */
	public static String getVlueByKey(Context context, String key)
	{
		String value = null;
		UTF8Properties properties = new UTF8Properties();
		try
		{
			properties.load(context.getAssets().open("config.properties"));
			value = properties.getProperty(key);
			// value = ConvertUtil.convertToUTF_8(value);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return value;

	}

	// /**
	// * 方法待修改完善
	// * @param context
	// * @param key
	// * @param value
	// * @return oldValue
	// */
	// TODO:
	// public static Object putVlueByKey(Context context, String key, String
	// value) {
	// Object oldValue = null;
	// Properties properties = new Properties();
	// try {
	// properties.load(context.getAssets().open("config.properties"));
	// oldValue = properties.setProperty(key, value);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return oldValue;
	//
	// }

}
