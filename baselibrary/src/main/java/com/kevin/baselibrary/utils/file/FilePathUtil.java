package com.kevin.baselibrary.utils.file;

import android.content.Context;
import android.os.Environment;

import com.kevin.baselibrary.app.SuperApplication;

import java.io.File;

/**
 * 文件路径工具类
 *
 * @author blj
 */
public class FilePathUtil {

    /**
     * /mnt/sdcard
     */
    public static String SDCARD_PATH;
    public static String MEMORY_STORAGE_DIRECTORY;
    public static String DEFAULT_STORAGE_DIRECTORY;
    private static String DEFAULT_APP_DIRECTORY;// 应用路径


    private static String DB_FILE_ROOT_DIR;// 数据根目录
    public static String MEDIA_FILE_ROOT_DIR;// 媒体文件根路径
//	public static String DEFAULT_APP_DIRECTORY;// 应用路径


    static {

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
            DEFAULT_STORAGE_DIRECTORY = SDCARD_PATH;
        } else {
            MEMORY_STORAGE_DIRECTORY = Environment.getDataDirectory().getAbsolutePath();
            DEFAULT_STORAGE_DIRECTORY = MEMORY_STORAGE_DIRECTORY;
        }

    }

    /**
     * @return
     */
    public static String getSdcardPath() {
        return DEFAULT_STORAGE_DIRECTORY;
    }

    public static String getAppPath() {
        return getAppPath(SuperApplication.getContext());
    }

    /**
     * @param context
     * @return /mnt/sdcard/packageName
     */
    private static String getAppPath(Context context) {
        if (context != null && DEFAULT_STORAGE_DIRECTORY != null) {
            File file = new File(DEFAULT_STORAGE_DIRECTORY + File.separator + context.getPackageName());
            if (!file.exists()) {
                file.mkdirs();
            }
            DEFAULT_APP_DIRECTORY = file.getAbsolutePath();
            return DEFAULT_APP_DIRECTORY;
        }
        return null;
    }

    /**
     * 设置数据库 文件根目录
     *
     * @param dbFilePath
     */
    public static void setDBFileRootDir(String dbFilePath) {
        DB_FILE_ROOT_DIR = dbFilePath;
    }

    /**
     * 获取数据库文件 DIR
     *
     * @return
     */
    public static String getDbFileRootDir() {
        return DB_FILE_ROOT_DIR;
    }

    /**
     * 设置多媒体 文件根目录
     *
     * @param dbFilePath
     */
    public static void setMediaFileRootDir(String dbFilePath) {
        MEDIA_FILE_ROOT_DIR = dbFilePath;
    }

    /**
     * 获取多媒体 文件 DIR
     *
     * @return
     */
    public static String getMediaFileRootDir() {
        return MEDIA_FILE_ROOT_DIR;
    }


}
