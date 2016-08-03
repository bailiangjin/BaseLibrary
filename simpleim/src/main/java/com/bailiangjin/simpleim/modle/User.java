package com.bailiangjin.simpleim.modle;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by bailiangjin on 16/8/3.
 */
public class User extends RealmObject {
    @PrimaryKey
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}


