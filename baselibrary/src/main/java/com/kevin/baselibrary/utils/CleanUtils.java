package com.kevin.baselibrary.utils;


import com.kevin.baselibrary.app.AppUtils;
import com.kevin.baselibrary.enums.SPKeyEnum;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/11/10 13:44
 */
public class CleanUtils {


    //----------------业务逻辑相关-------------------------------------------------------------------

    /**
     * 应用初始化时调用的 版本升级时清理本地文件的方法
     *
     * @param cleanRoot 是否清理应用文件根目录
     * @param cleanWeb  是否清理web资源缓存
     */
    public static void cleanAppFileDirOnUpdate(boolean cleanRoot, boolean cleanWeb) {
        int oldVersionCode = SPUtils.getInt(SPKeyEnum.APP_VERSION_CODE_KEY.toString());
        int currentVersionCode = AppUtils.getAppVersionCode(AppUtils.getContext().getPackageName());
        LogUtils.e("appversion:old:" + oldVersionCode + "::cur:" + currentVersionCode);


        if (-1 == oldVersionCode) {
            //在未安装或已卸载本应用的手机上一律执行清空应用根目录操作
            cleanAPPRootFileDir();
            LogUtils.e("cleanApp:cleanAPPRootFileDir newDevice");
        } else if (oldVersionCode < currentVersionCode) {
            if (cleanRoot) {
                //在已安装旧版本应用的手机上根据配置判断是否执行清空应用根目录操作
                cleanAPPRootFileDir();
                LogUtils.e("cleanApp:cleanAPPRootFileDir update");
            } else if (cleanWeb) {
                //在已安装旧版本应用的手机上根据配置判断是否执行清空web缓存目录和web界面相关数据库操作
//                cleanWebFileAndDBTable();
                LogUtils.e("cleanApp:cleanWebFileAndDBTable update");
            }
        }
        SPUtils.putInt(SPKeyEnum.APP_VERSION_CODE_KEY.toString(), currentVersionCode);
    }

    /**
     * 清空应用根文件目录
     *
     * @return
     */
    public static boolean cleanAPPRootFileDir() {

        return cleanAppRootFilePath();
    }

//    /**
//     * 清空web缓存和存放html页面的数据库表
//     */
//    public static void cleanWebFileAndDBTable() {
//       cleanWebFileDir();
//       cleanH5FragmentTable();
//
//    }


    //----------------本地文件相关-------------------------------------------------------------------

//    /**
//     * 清空web资源目录 www目录
//     *
//     * @return
//     */
//    public static boolean cleanWebFileDir() {
//        String webFileCachePath = FilePathUtil.getWebFileCachePath();
//        return FileUtils.deleteFile(webFileCachePath);
//    }


    /**
     * 清空应用包名文件夹(根文件夹)
     *
     * @return
     */
    public static boolean cleanAppRootFilePath() {
        String appFileRootPath = FilePathUtil.getAppPath();
        return FileUtils.deleteFile(appFileRootPath);
    }


    //-----------------------数据库相关操作----------------------------------------------------------




}
