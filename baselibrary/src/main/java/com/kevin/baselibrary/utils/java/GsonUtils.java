package com.kevin.baselibrary.utils.java;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Gson 工具类
 * 
 * @author blj
 * 
 */
public class GsonUtils {
    private volatile static GsonUtils instance = null;
    private static Gson gson = null;

    public static GsonUtils getInstance() {
        if (null == instance) {
            synchronized (GsonUtils.class) {
                if (null == instance) {
                    instance = new GsonUtils();
                }
            }
        }
        return instance;
    }

    private GsonUtils() {
        gson = new Gson();
    }

    public <T> T toObj(String json, Class<T> T) {
        return gson.fromJson(json, T);
    }

    public String toJson(Object obj) {
        return gson.toJson(obj);
    }
    
    
    /**
     * 将json 字符串转换为 String List
     * 
     * @param listJsonStr
     * @return String list
     */
    public List<String> parsJson2StringList(String listJsonStr) {
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        List<String> list = gson.fromJson(listJsonStr, type);

        if (null != list) {
            return list;
        }
        return null;
    }

    public Gson getGson(){
        return gson;
    }

  

}
