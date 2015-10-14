package com.kevin.baselibrary.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.app.SuperApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * android 应用程序工具
 *
 * @author qianjunping
 */
public class AppUtils {

    /**
     * 再点一次退出应用 上次点击时间
     */
    private static long lastTouchTime = 0;

    public static void oneMoreClickExitApp(Activity activity) {
        //间隔时间 阈值 毫秒
        final long gapTime = 2000;

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTouchTime > gapTime) {
            ToastUtils.show(R.string.one_more_click_exit);
            lastTouchTime = currentTime;
            return;
        } else {
            activity.finish();
            AppUtils.exit();
        }
    }


    public static Context getContext() {
        return SuperApplication.getContext();
    }

    /**
     * 当前activity是否在运行
     *
     * @return
     */
    public static boolean isAppRunningForeground() {

        ActivityManager localActivityManager = (ActivityManager) getContext()
                .getSystemService("activity");
        List localList = localActivityManager.getRunningTasks(1);
        return getContext()
                .getPackageName()
                .equalsIgnoreCase(
                        ((ActivityManager.RunningTaskInfo) localList.get(0)).baseActivity
                                .getPackageName());
    }

    /**
     * 应用程序是否运行在后台
     *
     * @return
     */
    public static boolean isBackground() {
        Context context = getContext();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        for (RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                if (appProcess.importance == RunningAppProcessInfo.IMPORTANCE_BACKGROUND) {
                    Log.i("后台", appProcess.processName);
                    return true;
                } else {
                    Log.i("前台", appProcess.processName);
                    return false;
                }
            }
        }
        return false;
    }


    /**
     * 强制退出应用程序
     */
    public static void exit() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }

    /**
     * 获取deviceId
     *
     * @param context
     * @return
     */
    public static String getDeviceId(Context context) {
        return Secure
                .getString(context.getContentResolver(), Secure.ANDROID_ID);
    }

    /**
     * 获得清单文件的MetaData
     *
     * @param key
     * @return
     */
    public static Object getAppMetaData(String key) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);
            if (applicationInfo == null) {
                return null;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null) {
                return null;
            }

            return bundle.get(key);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCurrentAppPackageName() {
        return SuperApplication.getContext().getPackageName();
    }


    /**
     * 获得当前app的 viersionCode
     *
     * @return int viersionCode
     */
    public static int getCurrentAppVersionCode() {
        return getAppVersionCode(getCurrentAppPackageName());
    }

    /**
     * 获得当前app的 viersionName
     *
     * @return string viersionName
     */
    public static String getCurrentAppVersionName() {
        return getAppVersionName(getCurrentAppPackageName());
    }


    /**
     * 获取当前应用名
     *
     * @param packageName
     * @return
     */
    public static String getCurrentAppName(String packageName) {
        return getAppName(getContext().getPackageName());
    }

    /**
     * 获得app的 viersionCode
     *
     * @param packageName 应用包名
     * @return
     */
    public static int getAppVersionCode(String packageName) {
        Context context = SuperApplication.getContext();
        PackageInfo info = null;
        try {
            if (packageName != null) {
                info = context.getPackageManager().getPackageInfo(packageName,
                        PackageManager.GET_CONFIGURATIONS);
            } else {
                info = context.getPackageManager().getPackageInfo(
                        context.getPackageName(),
                        PackageManager.GET_CONFIGURATIONS);
            }
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    /**
     * 获得app的VersionName
     */
    public static String getAppVersionName(String packageName) {

        Context context = SuperApplication.getContext();
        PackageInfo info = null;
        try {
            if (packageName != null) {
                info = context.getPackageManager().getPackageInfo(packageName,
                        PackageManager.GET_CONFIGURATIONS);
            } else {
                info = context.getPackageManager().getPackageInfo(
                        context.getPackageName(),
                        PackageManager.GET_CONFIGURATIONS);
            }
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 取包名路径作为应用唯一标识
     */
    public static String getAppId() {

        return getContext().getPackageCodePath();
    }

    /**
     * 获取手机分辨率
     *
     * @param context
     * @return
     */
    public static String getPhoneResolution(Activity context) {
        DisplayMetrics displaysMetrics = new DisplayMetrics();
        // 获取手机窗口的Display 来初始化DisplayMetrics 对象 getManager()获取显示定制窗口的管理器。
        // 获取默认显示Display对象
        // 通过Display 对象的数据来初始化一个DisplayMetrics 对象
        context.getWindowManager().getDefaultDisplay()
                .getMetrics(displaysMetrics);
        return displaysMetrics.widthPixels + "*" + displaysMetrics.heightPixels;
    }

    /**
     * 获取手机分辨率宽
     *
     * @param context
     * @return
     */
    public static int getPhoneWidth(Activity context) {
        DisplayMetrics displaysMetrics = new DisplayMetrics();
        // 获取手机窗口的Display 来初始化DisplayMetrics 对象 getManager()获取显示定制窗口的管理器。
        // 获取默认显示Display对象
        // 通过Display 对象的数据来初始化一个DisplayMetrics 对象
        context.getWindowManager().getDefaultDisplay()
                .getMetrics(displaysMetrics);
        return displaysMetrics.widthPixels;
    }

    /**
     * 获取手机分辨率高
     *
     * @param context
     * @return
     */
    public static int getPhoneHeight(Activity context) {
        DisplayMetrics displaysMetrics = new DisplayMetrics();
        // 获取手机窗口的Display 来初始化DisplayMetrics 对象 getManager()获取显示定制窗口的管理器。
        // 获取默认显示Display对象
        // 通过Display 对象的数据来初始化一个DisplayMetrics 对象
        context.getWindowManager().getDefaultDisplay()
                .getMetrics(displaysMetrics);
        return displaysMetrics.heightPixels;
    }

    /**
     * 自动安装
     *
     * @param apkPath apk包的路径
     * @return
     */
    public static boolean autoInstallApk(String apkPath) {
        Context context = getContext();
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(new File(apkPath)),
                    "application/vnd.android.package-archive");
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 静默安装
     *
     * @return
     */
    public static boolean slientInstall(final String path) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                Process process = null;
                OutputStream out = null;
                InputStream in = null;
                try {
                    // 请求root
                    process = Runtime.getRuntime().exec("su");
                    out = process.getOutputStream();
                    // 调用安装
                    out.write(("pm install -r " + path + "\n").getBytes());
                    in = process.getInputStream();
                    int len = 0;
                    byte[] bs = new byte[256];
                    while (-1 != (len = in.read(bs))) {
                        String state = new String(bs, 0, len);
                        if (state.equals("Success\n")) {
                            // 安装成功后的操作
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (out != null) {
                            out.flush();
                            out.close();
                        }
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return null;
            }
        }.execute();
        return false;
    }

    /**
     * 判断应用是否安装
     *
     * @param packageName
     * @return
     */
    public static boolean isInstall(String packageName) {
        Context context = getContext();
        PackageInfo pInfo = null;
        if (packageName != null) {
            try {
                pInfo = context.getPackageManager().getPackageInfo(packageName,
                        0);
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (pInfo != null)
            return true;
        return false;
    }

    /**
     * 根据apk包判断是否已经安装
     *
     * @param apkPath
     * @return
     */
    public static boolean isInstallByApkPath(String apkPath) {
        return isInstall(getPackageNameFromApk(apkPath));
    }

    /**
     * 从apk文件获得程序的包名
     *
     * @param apkPath
     * @return
     */
    public static String getPackageNameFromApk(String apkPath) {
        PackageInfo apkInfo = getContext().getPackageManager()
                .getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);
        Log.i("NscAppManger", "apkPath: " + apkPath);
        if (apkInfo != null) {
            return apkInfo.packageName;
        }
        return null;
    }

    /**
     * 获取应用名
     *
     * @param packageName
     * @return
     */
    public static String getAppName(String packageName) {
        Context context = getContext();
        PackageManager packageManager = null;
        String applicationName = "";
        try {
            packageManager = context.getPackageManager();
            ApplicationInfo packageInfo = packageManager.getApplicationInfo(
                    packageName, 0);
            applicationName = (String) packageManager
                    .getApplicationLabel(packageInfo);
        } catch (NameNotFoundException e) {

            e.printStackTrace();
        }

        return applicationName;
    }

    /**
     * 卸载应用
     *
     * @param packageName
     */
    public static void unInstallApp(String packageName) {

        Intent intent = new Intent(Intent.ACTION_DELETE, Uri.parse("package:"
                + packageName));
        getContext().startActivity(intent);
    }

    public static boolean isWorked() {
        ActivityManager myManager = (ActivityManager) getContext()
                .getSystemService(Context.ACTIVITY_SERVICE);
        ArrayList<RunningServiceInfo> runningService = (ArrayList<RunningServiceInfo>) myManager
                .getRunningServices(30);
        for (int i = 0; i < runningService.size(); i++) {
            if (runningService.get(i).service.getClassName().toString()
                    .equals("com.android.controlAddFunctions.PhoneService")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据包名启动应用
     */
    public static void startApp(String packageName) {
        Intent intent = getContext().getPackageManager().getLaunchIntentForPackage(
                packageName);
        getContext().startActivity(intent);
    }

    /**
     * 从assets目录下拿取小文本文件的方法
     *
     * @param r        Resources对象
     * @param fileName Assets目录下的文件名
     * @return
     */
    public static String getStrFromAssets(Resources r, String fileName) {
        String result = null;
        try {
            InputStream in = r.getAssets().open(fileName);
            int ch = 0;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((ch = in.read()) != -1) {
                baos.write(ch);
            }
            byte[] buff = baos.toByteArray();
            baos.close();
            in.close();
            result = new String(buff, "UTF-8");
            result = result.replaceAll("\\r\\n", "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return sdf.format(date);
    }


    /**
     * 判断是否为平板 有效
     *
     * @return boolean
     */
    public static boolean isTablet() {
        return (getContext().getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


    /**
     * 判断是否为pad 在步步高vivo x510w 上误判为平板
     *
     * @return
     */
    public static boolean isPad() {

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);

        double x = Math.pow(dm.widthPixels / dm.xdpi, 2);
        double y = Math.pow(dm.heightPixels / dm.ydpi, 2);
        // 屏幕尺寸
        double screenInches = Math.sqrt(x + y);
        LogUtils.e("screenInches:" + screenInches);
        // 大于7尺寸则为Pad

        if (screenInches >= 7.0) {
            return true;
        }
        return false;
    }
}
