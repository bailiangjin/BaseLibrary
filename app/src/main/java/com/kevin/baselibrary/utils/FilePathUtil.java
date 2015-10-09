package com.kevin.baselibrary.utils;

import android.content.Context;
import android.os.Environment;

import com.kevin.baselibrary.app.BaseApplication;

import java.io.File;

/**
 * 文件路径工具类 IM工程特有功能 工具类 其他处使用UcFileUtil
 * 
 * @author blj
 * 
 */
public class FilePathUtil
{

	/**
	 * /mnt/sdcard
	 */
	public static String SDCARD_PATH;
	public static String MEMORY_STORAGE_DIRECTORY;
	public static String DEFAULT_STORAGE_DIRECTORY;
	public static String DEFAULT_APP_DIRECTORY;// 应用路径

	static
	{

		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
		{

			SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
			DEFAULT_STORAGE_DIRECTORY = SDCARD_PATH;
		}
		else
		{
			MEMORY_STORAGE_DIRECTORY = Environment.getDataDirectory().getAbsolutePath();
			DEFAULT_STORAGE_DIRECTORY = MEMORY_STORAGE_DIRECTORY;
		}

	}

	/**
	 * 
	 * @return
	 */
	public static String getSdcardPath()
	{
		return DEFAULT_STORAGE_DIRECTORY;
	}

	public static String getAppPath(){
		return getAppPath(BaseApplication.getContext());
	}

	/**
	 * 
	 * @param context
	 * @return /mnt/sdcard/packageName
	 */
	private static String getAppPath(Context context)
	{
		if (context != null && DEFAULT_STORAGE_DIRECTORY != null)
		{
			File file = new File(DEFAULT_STORAGE_DIRECTORY + File.separator + context.getPackageName());
			if (!file.exists())
			{
				file.mkdirs();
			}
			DEFAULT_APP_DIRECTORY = file.getAbsolutePath();
			return DEFAULT_APP_DIRECTORY;
		}
		return null;
	}

}
