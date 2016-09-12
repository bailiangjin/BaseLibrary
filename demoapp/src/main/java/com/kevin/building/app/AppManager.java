package com.kevin.building.app;

import android.app.Activity;
import android.content.Intent;

import com.kevin.building.R;

/**
 * 应用程序Activity管理类：用于Activity管理和应用程序
 */
public class AppManager {
    // 用来存放所有打开的activity，以便退出便利关闭

    private static AppManager instance;

    private AppManager() {
    }

    /**
     * 单一实例
     */
    public static AppManager getInstance() {
        if (instance == null) {
            synchronized (AppManager.class) {
                instance = new AppManager();
            }

        }
        return instance;
    }

    /**
     * activity 启动
     *
     * @param activity
     * @param intent
     */
    public void startActivity(Activity activity, Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // appIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }
//
//    public void startActivityForResult(Activity activity, Intent intent, int requestCode) {
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        activity.startActivityForResult(intent, requestCode);
//        activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
//    }




//    /**
//     * 注销当前账户
//     */
//    public void logout() {
//        try {
//            finishAllActivityExceptLoginAndMain();
//        } catch (Exception e) {
//        }
//    }

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