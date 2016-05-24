package com.kevin.baselibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.kevin.baselibrary.app.SuperApplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class SPUtils {
    /**
     * 保存在手机里面的文件名
     */
    public static final String FILE_NAME = "share_data";

    public SPUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }




    public static void put(String key, Object obj) {
        put(SuperApplication.getContext(), key, obj);
    }

    public static void putString(String key, String value) {
        putString(SuperApplication.getContext(), key, value);
    }

    public static String getString(String key) {
        return getString(SuperApplication.getContext(), key);
    }


    public static void putInt(String key, int value) {
        put(key, value);
    }


    public static int getInt(String key) {
        return getInt(key, -1);
    }


    public static int getInt(String key, int defaultValue) {
        return (int) get(SuperApplication.getContext(), key, -1);
    }


    /**
     * 保存boolean数据的方法
     *
     * @param key
     */
    public static void putBoolean(String key, boolean value) {
        putBoolean(SuperApplication.getContext(), key, value);
    }

    /**
     * 获取boolean 方法
     *
     * @param key
     * @return
     */
    public static boolean getBoolean(String key) {

        return (Boolean) get(SuperApplication.getContext(), key, false);
    }


    public static void remove(String key) {
        remove(SuperApplication.getContext(), key);
    }


    /**
     * 保存boolean数据的方法
     *
     * @param context
     * @param key
     */
    public static void putBoolean(Context context, String key, boolean value) {
        put(context, key, value);
    }

    /**
     * 获取boolean 方法
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = getSp(context);
        return sp.getBoolean(key, false);
    }

    private static SharedPreferences getSp(Context context) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }


    /**
     * 保存String的方法
     *
     * @param context
     * @param key
     * @param str
     */
    public static void putString(Context context, String key, String str) {
        if (null == str) {
            return;
        }
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, str);
        SharedPreferencesCompat.apply(editor);
    }


    /**
     * 获取String 方法
     *
     * @param context
     * @param key
     * @param defaltStr
     * @return
     */
    public static String getStringDef(Context context, String key, String defaltStr) {
        SharedPreferences sp = getSp(context);

        return sp.getString(key, defaltStr);
    }

    /**
     * 获取String 方法
     *
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {
        SharedPreferences sp = getSp(context);
        return sp.getString(key, null);
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 清除所有数据
     *
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = getSp(context);
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = getSp(context);
        return sp.getAll();
    }


    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param obj
     */
    public static void put(Context context, String key, Object obj) {

        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();

        if (obj instanceof String) {
            editor.putString(key, (String) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(key, (Integer) obj);
        } else if (obj instanceof Boolean) {
            editor.putBoolean(key, (Boolean) obj);
        } else if (obj instanceof Float) {
            editor.putFloat(key, (Float) obj);
        } else if (obj instanceof Long) {
            editor.putLong(key, (Long) obj);
        } else {
            editor.putString(key, obj.toString());
        }

        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObj
     * @return
     */
    public static Object get(Context context, String key, Object defaultObj) {
        SharedPreferences sp = getSp(context);

        if (defaultObj instanceof String) {
            return sp.getString(key, (String) defaultObj);
        } else if (defaultObj instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObj);
        } else if (defaultObj instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObj);
        } else if (defaultObj instanceof Float) {
            return sp.getFloat(key, (Float) defaultObj);
        } else if (defaultObj instanceof Long) {
            return sp.getLong(key, (Long) defaultObj);
        }

        return null;
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            editor.commit();
        }
    }

}