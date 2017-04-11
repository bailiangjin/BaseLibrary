package com.bailiangjin.utilslibrary.config;

import android.annotation.SuppressLint;
import android.content.Context;

import com.bailiangjin.utilslibrary.utils.app.AppUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取配置文件工具类 需要在assets目录下放置config.properties文件在其中写入键值对 格式：key=value
 *
 * @author blj
 */
public class ConfigUtils {

    /**
     * 读取配置文件方法
     *
     * @param key 键
     * @return value 值
     */
    public static String getValueByKey(String key) {
        Context context = AppUtils.getContext();
        String value = null;
        UTF8Properties properties = new UTF8Properties();
        try {
            properties.load(context.getAssets().open("config.properties"));
            value = properties.getProperty(key);
            // value = ConvertUtil.convertToUTF_8(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;

    }


    /**
     * UTF8配置文件读取类 继承自java.util.Properties 覆盖读入配置文件的方法 实现读取UTF_8格式配置文件
     *
     * @author blj
     */
    static class UTF8Properties extends Properties {

        @SuppressLint("NewApi")
        @Override
        public synchronized void load(InputStream in) throws IOException {
            if (in == null) {
                throw new NullPointerException("in == null");
            }
            load(new InputStreamReader(in, "UTF_8"));
        }

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
