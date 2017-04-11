package com.bailiangjin.utilslibrary.utils.file;

import android.support.v4.util.LruCache;

import com.bailiangjin.javabaselib.utils.StringUtils;

/**
 *  万能的 三级缓存类
 * Created by bailiangjin on 16/5/30.
 */
public class ThreeLevelCache<T> {
    private static volatile ThreeLevelCache instance = null;

    private LruCache<String, T> mLruCache;

    private int defaultSize = 3;

    public static ThreeLevelCache getInstance() {
        if (instance == null) {
            synchronized (ThreeLevelCache.class) {
                if (instance == null) {
                    instance = new ThreeLevelCache();
                }
            }
        }
        return instance;
    }

    private ThreeLevelCache() {
        mLruCache = new LruCache<>(defaultSize);
    }

    public void resize(int size) {
        mLruCache.resize(size);
    }

    public void put(String key, T t) {
        if (StringUtils.isEmpty(key) || null == t) {
            return;
        }
        key=t.getClass().getName()+key;
        mLruCache.put(key, t);
    }

    public T get(String key,Class<T> clazz) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key=clazz.getName()+key;
        return mLruCache.get(key);
    }

    public void remove(String key,Class<T> clazz) {
        if (StringUtils.isEmpty(key)) {
            return;
        }
        key=clazz.getName()+key;
        mLruCache.remove(key);
    }


}