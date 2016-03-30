package com.kevin.baselibrary.utils;

import com.google.gson.internal.Primitives;
import com.kevin.javabaselib.utils.GsonUtils;

import java.lang.reflect.Type;

/**
 * 使用SP实现的缓存工具类 可缓存 支持Gson序列化的对象
 * Created by bailiangjin on 16/3/25.
 */
public class SPCacheUtils {

    /**
     * 去医院界面信息缓存 SP Key
     */
    private static final String HOSPITAL_CACHE_KEY = "gotoHospitalCache";


//    /**
//     * 缓存 去医院界面信息 到SP
//     * @param gotoHospitalEntity
//     */
//    public static void cacheGotoHospitalEntity(GotoHospitalEntity gotoHospitalEntity) {
//        cacheObj(HOSPITAL_CACHE_KEY, gotoHospitalEntity);
//    }
//
//    /**
//     * 从缓存中 获取 去医院界面信息
//     * @return GotoHospitalEntity
//     */
//    public static GotoHospitalEntity getGotoHospitalEntity() {
//        return getObj(HOSPITAL_CACHE_KEY, GotoHospitalEntity.class);
//    }

    /**
     * 缓存 Object到 SP
     * @param key 键值
     * @param obj Object 对象 ps:支持Gson序列化的对象
     */
    public static void cacheObj(String key, Object obj) {
        SPUtils.putString(key, GsonUtils.getInstance().toJson(obj));
    }


    /**
     * 从SP缓存中  取Object
     * @param key 键值
     * @param classOfT 类型
     * @param <T>
     * @return T
     */
    public static <T> T getObj(String key, Class<T> classOfT) {
        String json = (String) SPUtils.getString(key);//TODO:备注:默认数据传null 会使得返回结果为null
        try {
            Object object = GsonUtils.getInstance().getGson().fromJson(json, (Type) classOfT);
            return Primitives.wrap(classOfT).cast(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


}
