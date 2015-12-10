package com.kevin.building.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.kevin.building.MainActivity;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用程序Activity管理类：用于Activity管理和应用程序
 * 
 */
public class AppManager
{
	// 用来存放所有打开的activity，以便退出便利关闭
	private static ArrayList<Activity> list_activity;

	private static AppManager instance;

	private AppManager()
	{
	}

	/**
	 * 单一实例
	 */
	public static AppManager getInstance()
	{
		if (instance == null)
		{
			synchronized (AppManager.class)
			{
				instance = new AppManager();
			}

		}
		return instance;
	}

	/**
	 * 添加Activity到堆
	 */
	public void addActivity(Activity activity)
	{
		if (list_activity == null)
		{
			list_activity = new ArrayList<Activity>();
		}
		list_activity.add(activity);
	}

	/**
	 * 获取当前Activity
	 */
	public Activity currentActivity()
	{
		if (!list_activity.isEmpty())
		{
			Activity activity = list_activity.get(list_activity.size() - 1);
			return activity;
		}
		else
		{
			return null;
		}
	}

	/**
	 * 结束当前Activity
	 */
	public void finishActivity()
	{
		finishActivity(currentActivity());
	}

	/**
	 * 结束指定的Activity
	 */
	public void finishActivity(Activity activity)
	{
		if (activity != null)
		{
			list_activity.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity
	 */
	public void finishActivity(Class<?> cls)
	{
		for (Activity activity : list_activity)
		{
			if (activity.getClass().equals(cls))
			{
				finishActivity(activity);
				break;
			}
		}
	}

	/**
	 * 结束所有指定类名的Activity
	 */
	public void finishAllActivity(Class<?> cls)
	{

		List<Activity> list = new ArrayList<Activity>();
		list.addAll(list_activity);
		for (Activity activity : list)
		{
			if (activity.getClass().equals(cls))
			{
				finishActivity(activity);
			}
		}
	}

	/**
	 * 如果包含main activity返回为true 否则为false
	 */
	public boolean isHasMainActivity()
	{
		if (list_activity.isEmpty())
		{
			return false;
		}
		for (Activity activity : list_activity)
		{
			if (activity.getClass().equals(MainActivity.class))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 结束Activity
	 */
	public void finishAllActivity()
	{
		for (int i = 0, size = list_activity.size(); i < size; i++)
		{
			if (null != list_activity.get(i))
			{
				list_activity.get(i).finish();
			}
		}
		list_activity.clear();
	}

	/**
	 * activity 启动
	 * 
	 * @param activity
	 * @param intent
	 */
	public void startActivity(BaseActivity activity, Intent intent)
	{
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		// appIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		activity.startActivity(intent);
		activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
	}

	public void startActivityForResult(Activity activity, Intent intent, int requestCode)
	{
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		activity.startActivityForResult(intent, requestCode);
		activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
	}

	/**
	 * * 应用程序退出
	 */
	public void AppExit(Context context)
	{
		try
		{
			finishAllActivity();
			// ActivityManager activityMgr = (ActivityManager)
			// context.getSystemService(Context.ACTIVITY_SERVICE);
			// activityMgr.restartPackage(context.getPackageName());
			System.exit(0);
		}
		catch (Exception e)
		{
		}
	}

//	/**
//	 * 被踢出群
//	 */
//	public void kickOut(boolean isConnect)
//	{
//		ArrayList<Activity> finishList = new ArrayList<Activity>();
//		if (isConnect)
//		{
//			for (int i = 0, size = list_activity.size(); i < size; i++)
//			{
//				if (null != list_activity.get(i) && !(list_activity.get(i) instanceof MainActivity))
//				{
//					finishList.add(list_activity.get(i));
//					list_activity.get(i).finish();
//				}
//			}
//		}
//		else
//		{
//			for (int i = 0, size = list_activity.size(); i < size; i++)
//			{
//				if (null != list_activity.get(i) && !(list_activity.get(i) instanceof LoginActivity))
//				{
//					finishList.add(list_activity.get(i));
//					list_activity.get(i).finish();
//				}
//			}
//		}
//		list_activity.removeAll(finishList);
//	}

}