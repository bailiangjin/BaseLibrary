package com.bailiangjin.simpleim.appcommon.db;

import com.bailiangjin.simpleim.engine.logicutils.AccountUtils;
import com.kevin.baselibrary.utils.app.AppUtils;
import com.kevin.baselibrary.utils.LogUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by bailiangjin on 16/8/3.
 */
public enum RealmService {

    INSTANCE;

    private RealmConfiguration realmConfig;
    private Realm realm;

    private RealmService() {
        realmConfig = new RealmConfiguration.Builder(AppUtils.getContext())
                .deleteRealmIfMigrationNeeded()
                .name(String.valueOf(AccountUtils.getCurrentUserId())).build();
        // Open the Realm for the UI thread.
        realm = Realm.getInstance(realmConfig);
    }


    /**
     * 存储list
     *
     * @param list
     * @param <T>
     */
    public <T extends RealmObject> void saveOrUpdateList(List<T> list) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(list);
        realm.commitTransaction();
    }

    /**
     * 存储obj
     *
     * @param t
     * @param <T>
     */
    public <T extends RealmObject> void saveOrUpdateObj(T t) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(t);
        realm.commitTransaction();
    }

    /**
     * 按条件查找 首个
     *
     * @param key
     * @param value
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends RealmObject> T findObj(String key, String value, Class<T> clazz) {

        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return findObj(map, clazz);
    }


    /**
     * 按条件查找 首个
     *
     * @param map   key value map
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends RealmObject> T findObj(Map<String, Object> map, Class<T> clazz) {
        T result = null;
        realm.beginTransaction();
        RealmQuery<T> realmQuery = realm.where(clazz);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            LogUtils.e("searchKey:" + key + "=" + value);
            realmQuery = realmQuery.equalTo(key, value);
        }
        result = realmQuery.findFirst();
        realm.commitTransaction();
        return result;
    }


    /**
     * 按条件查找 多个
     *
     * @param key
     * @param value
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends RealmObject> List<T> findObjs(String key, String value, Class<T> clazz) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return findObjs(map, clazz);
    }

    /**
     * 按条件查找 多个
     *
     * @param map   key value map
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends RealmObject> List<T> findObjs(Map<String, Object> map, Class<T> clazz) {
        List<T> resultList = null;
        realm.beginTransaction();
        RealmQuery<T> realmQuery = realm.where(clazz);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            LogUtils.e("searchKey:" + key + "=" + value);
            realmQuery = realmQuery.equalTo(key, value);
        }
        resultList = realmQuery.findAll();
        return resultList;
    }


    /**
     * 删除满足条件的元素
     *
     * @param key
     * @param value
     * @param clazz 类型
     * @param <T>
     * @return
     */
    public <T extends RealmObject> boolean deleteObjs(String key, String value, Class<T> clazz) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return deleteObjs(map, clazz);
    }


    /**
     * 删除满足条件的元素
     *
     * @param map
     * @param clazz 类型
     * @param <T>
     * @return
     */
    public <T extends RealmObject> boolean deleteObjs(Map<String, Object> map, Class<T> clazz) {
        realm.beginTransaction();
        RealmResults<T> resultList = null;
        RealmQuery<T> realmQuery = realm.where(clazz);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            LogUtils.e("searchKey:" + key + "=" + value);
            realmQuery = realmQuery.equalTo(key, value);
        }
        resultList = realmQuery.findAll();
        if (null != resultList) {
            resultList.deleteAllFromRealm();
            realm.commitTransaction();
            return true;
        }
        realm.commitTransaction();
        return false;
    }


    /**
     * 删除某一类对象
     *
     * @param clazz
     * @param <T>
     */
    public <T extends RealmObject> void deleteClass(Class<T> clazz) {
        realm.beginTransaction();
        realm.delete(clazz);
        realm.commitTransaction();
    }


}
