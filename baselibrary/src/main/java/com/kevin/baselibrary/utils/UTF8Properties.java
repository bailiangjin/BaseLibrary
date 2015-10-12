package com.kevin.baselibrary.utils;

import android.annotation.SuppressLint;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * UTF8配置文件读取类 继承自java.util.Properties 覆盖读入配置文件的方法 实现读取UTF_8格式配置文件
 * 
 * @author blj
 * 
 */
public class UTF8Properties extends Properties
{

	@SuppressLint("NewApi")
	@Override
	public synchronized void load(InputStream in) throws IOException
	{
		if (in == null)
		{
			throw new NullPointerException("in == null");
		}
		load(new InputStreamReader(in, "UTF_8"));
	}

}
