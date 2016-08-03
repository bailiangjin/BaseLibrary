package com.bailiangjin.simpleim.db;

import com.bailiangjin.simpleim.modle.User;

/**
 * Created by bailiangjin on 16/8/3.
 */
public class ImDbUtils {

    public static void saveOrUpdateUser(User user) {
        RealmService.INSTANCE.saveOrUpdateObj(user);
    }
    public static User findUser(User user) {
        return RealmService.INSTANCE.findObj("id", user.getId(), User.class);
    }

    public static User findUser(String  userId) {
        return RealmService.INSTANCE.findObj("id", userId, User.class);
    }
}
