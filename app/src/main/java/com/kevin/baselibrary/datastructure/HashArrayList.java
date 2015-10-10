package com.kevin.baselibrary.datastructure;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * 自定义 哈希 list 保证list中无重复元素
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/10 16:51
 */
public class HashArrayList extends ArrayList {

    private HashSet hashSet = new HashSet();

    @Override
    public boolean remove(Object object) {
        hashSet.remove(object);
        return super.remove(object);
    }

    @Override
    public Object remove(int index) {
        hashSet.remove(get(index));
        return super.remove(index);
    }

    @Override
    public boolean addAll(Collection collection) {
        Collection hashCollection = toHashCollection(collection);
        hashSet.addAll(hashCollection);
        return super.addAll(hashCollection);
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        Collection hashCollection = toHashCollection(collection);
        hashSet.addAll(hashCollection);
        return super.addAll(index, hashCollection);
    }

    /**
     * 将 collection 转为不包含重复元素的HashCollection 标准 元素哈希值
     *
     * @param collection
     * @return
     */
    @NonNull
    private Collection toHashCollection(Collection collection) {
        if (collection.size() < 0) {
            return null;
        }
        HashSet allSet = new HashSet(collection);
        Collection hashCollection = Arrays.asList(allSet.toArray());
        return hashCollection;
    }

    @Override
    public void add(int index, Object object) {

        if (hashSet.contains(object)) {
            //
        } else {
            hashSet.add(object);
            super.add(index, object);
        }
    }

    @Override
    public boolean add(Object object) {
        if (hashSet.contains(object)) {
            return false;
        } else {
            hashSet.add(object);
            return super.add(object);
        }
    }

    @Override
    public void clear() {
        hashSet.clear();
        super.clear();

    }
}
