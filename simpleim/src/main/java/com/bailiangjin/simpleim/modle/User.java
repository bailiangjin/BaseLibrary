package com.bailiangjin.simpleim.modle;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by bailiangjin on 16/8/3.
 */
public class User extends RealmObject {
    @PrimaryKey
    private String id;
    private String hxId;
    private String name;
    private String password;
    private String headUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHxId() {
        return hxId;
    }

    public void setHxId(String hxId) {
        this.hxId = hxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}


