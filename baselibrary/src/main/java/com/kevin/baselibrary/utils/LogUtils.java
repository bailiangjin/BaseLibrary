package com.kevin.baselibrary.utils;

import android.util.Log;

/**
 * 
 * @author blj
 * 
 */
public class LogUtils
{
	private static String TAG = "Building";
	private static String INFO = "-->>";
	private static String INIO = "::";
	private static int DEBUG = 0;
	public final static int LOG_DUBEG = 0;
	public final static int LOG_INFO = 1;
	public final static int LOG_WARN = 2;
	public final static int LOG_ERROR = 3;

	public final static void e(String message)
	{
		if (DEBUG <= LOG_ERROR)
		{
			StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
			Log.e(TAG,
					stackTrace.getClassName() + INIO + stackTrace.getLineNumber() + INIO + stackTrace.getMethodName()
							+ INFO + message);
		}
	}

	public final static void i(String message)
	{
		if (DEBUG <= LOG_INFO)
		{
			StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
			Log.i(TAG,
					stackTrace.getClassName() + INIO + stackTrace.getLineNumber() + INIO + stackTrace.getMethodName()
							+ INFO + message);
		}
	}

	public final static void d(String message)
	{
		if (DEBUG <= LOG_DUBEG)
		{
			StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
			Log.d(TAG,
					stackTrace.getClassName() + INIO + stackTrace.getLineNumber() + INIO + stackTrace.getMethodName()
							+ INFO + message);
		}
	}

	public final static void w(String message)
	{
		if (DEBUG <= LOG_WARN)
		{
			StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
			Log.w(TAG,
					stackTrace.getClassName() + INIO + stackTrace.getLineNumber() + INIO + stackTrace.getMethodName()
							+ INFO + message);
		}
	}
}
