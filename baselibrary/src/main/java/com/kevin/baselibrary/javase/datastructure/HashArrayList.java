package com.kevin.baselibrary.javase.datastructure;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
    protected void removeRange(int fromIndex, int toIndex) {
        if (fromIndex == toIndex) {
            return;
        }
        for (int i = fromIndex; i < toIndex; i++) {
            hashSet.remove(get(i));
        }
        super.removeRange(fromIndex, toIndex);
    }

    @Override
    public boolean addAll(Collection collection) {
        Collection abHashCollection = toABHashList(collection);
        hashSet.addAll(abHashCollection);
        return super.addAll(abHashCollection);
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        Collection abHashCollection = toABHashList(collection);
        hashSet.addAll(abHashCollection);
        return super.addAll(index, abHashCollection);
    }

    /**
     * 将 collection 转为不包含自身原来重复元素的HashCollection 标准 元素哈希值
     *
     * @param collection
     * @return
     */
    @NonNull
    private List toHashList(Collection collection) {
        if (null == collection || collection.size() <= 0) {
            return null;
        }
        HashSet allSet = new HashSet(collection);
        List hashList = Arrays.asList(allSet.toArray());
        return hashList;
    }

    /**
     * 将 collection 转为不包含重复元素的HashList 并删除HashSet中已包含的元素
     *
     * @param collection
     * @return
     */
    @NonNull
    private List toABHashList(Collection collection) {
        if (null == collection || collection.size() <= 0) {
            return null;
        }
        //遍历删除HashSet中已包含的元素
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (hashSet.contains(obj)) {
                iterator.remove();
            }
        }
        List abHashList = toHashList(collection);
        return abHashList;
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
