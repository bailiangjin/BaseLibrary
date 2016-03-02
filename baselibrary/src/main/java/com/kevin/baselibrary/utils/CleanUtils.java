package com.kevin.baselibrary.utils;


import com.kevin.baselibrary.app.AppUtils;
import com.kevin.baselibrary.config.CleanOptions;
import com.kevin.baselibrary.enums.SPKeyEnum;
import com.kevin.javabaselib.utils.FileUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/11/10 13:44
 */
public class CleanUtils {


    //----------------业务逻辑相关-------------------------------------------------------------------

    /**
     * 应用初始化时调用的 版本升级时清理本地文件的方法
     */
    public static void cleanAppFileDirOnUpdate(CleanOptions cleanOptions) {
        int oldVersionCode = SPUtils.getInt(SPKeyEnum.APP_VERSION_CODE_KEY.toString());
        int currentVersionCode = AppUtils.getAppVersionCode(AppUtils.getContext().getPackageName());
        LogUtils.e("appversion:old:" + oldVersionCode + "::cur:" + currentVersionCode);


        if (-1 == oldVersionCode) {
            //在未安装或已卸载本应用的手机上
            //一律执行清空应用根目录操作
            cleanAppRootFileDir();
            LogUtils.e("cleanApp:cleanAppRootFileDir newDevice");
        } else if (oldVersionCode < currentVersionCode) {
            //在已安装旧版本应用的手机上
            if (cleanOptions.isCleanRootDir()) {
                //是否执行清空应用根目录操作
                cleanAppRootFileDir();
                LogUtils.e("cleanApp:cleanAppRootFileDir update");
            } else {
                if (cleanOptions.isCleanDBDir()) {
                    //执行清空数据库操作
                    LogUtils.e("cleanApp:cleanDBDir update");
                }
                if (cleanOptions.isCleanMediaDir()) {
                    //清空媒体目录
                    LogUtils.e("cleanApp:cleanMedia update");
                }
                if (cleanOptions.isCleanOtherDir()) {
                    //执行清空otherDir
                    LogUtils.e("cleanApp:cleanOtherDir update");
                }
            }
        }
        SPUtils.putInt(SPKeyEnum.APP_VERSION_CODE_KEY.toString(), currentVersionCode);
    }

    /**
     * 清空应用根文件目录
     *
     * @return
     */
    public static boolean cleanAppRootFileDir() {

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
