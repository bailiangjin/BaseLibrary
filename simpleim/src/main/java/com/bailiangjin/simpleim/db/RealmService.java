package com.bailiangjin.simpleim.db;

import com.bailiangjin.simpleim.engine.logicutils.AccountUtils;
import com.bailiangjin.simpleim.modle.User;
import com.kevin.baselibrary.app.AppUtils;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by bailiangjin on 16/8/3.
 */
public enum RealmService {

    INSTANCE;

    private RealmConfiguration realmConfig;
    private Realm realm;

    private RealmService() {
        realmConfig = new RealmConfiguration.Builder(AppUtils.getContext()).deleteRealmIfMigrationNeeded().name(String.valueOf(AccountUtils.getCurrentUserId())).build();
        // Open the Realm for the UI thread.
        realm = Realm.getInstance(realmConfig);
    }


    public void saveOrUpdateObj(RealmObject realmObject) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(realmObject);
        realm.commitTransaction();
    }

    public User findUser(User user) {
        return findObj("id", user.getId(), User.class);
    }

    public <T extends RealmObject> T findObj(String key, String value, Class<T> clazz) {
        T result = null;
        realm.beginTransaction();
        result = realm.where(clazz).equalTo(key, value).findFirst();
        realm.commitTransaction();
        return result;
    }




    public <T extends RealmObject> List<T> findObjs(String key, String value, Class<T> clazz) {
        List<T> resultList = null;
        realm.beginTransaction();
        resultList = realm.where(clazz).equalTo(key, value).findAll();
        realm.commitTransaction();
        return resultList;
    }


    /**
     * 删除满足条件的元素
     * @param key
     * @param value
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends RealmObject> boolean deleteObjs(String key, String value, Class<T> clazz) {
        realm.beginTransaction();
        RealmResults<T> resultList = null;
        resultList = realm.where(clazz).equalTo(key, value).findAll();
        if(null!=resultList){
            resultList.deleteAllFromRealm();
            realm.commitTransaction();
            return true;
        }
        realm.commitTransaction();
        return false;
    }

    public <T extends RealmObject> void deleteClass(Class<T> clazz) {
        realm.beginTransaction();
        realm.delete(clazz);
        realm.commitTransaction();
    }


}
