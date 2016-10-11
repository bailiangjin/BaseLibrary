package com.bailiangjin.simpleim.engine.logicutils;

import com.bailiangjin.simpleim.constants.SPKey;
import com.bailiangjin.simpleim.appcommon.db.ImDbUtils;
import com.bailiangjin.simpleim.modle.User;
import com.kevin.baselibrary.constant.SuperSPKey;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.SPUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/10 14:09
 */
public class AccountUtils {

    public static String  getCurrentUserId(){
        return getUserName();
    }

    /**
     * 账户信息登出
     *
     * @return
     */
    public static boolean logout() {

        // SPUtils.remove(SuperSPKey.USER_NAME);
        //清空存储的密码
        SPUtils.remove(SPKey.PASSWORD);
        //清空是否清楚密码勾选框状态
        SPUtils.remove(SPKey.SAVEPWD);
        //清除登录状态标识
        SPUtils.remove(SPKey.IS_LOGINED);
        return true;
    }

    public static boolean isLoginStatus(){
        return SPUtils.getBoolean(SPKey.IS_LOGINED);
    }


    /**
     * 保存登录信息
     *
     * @param userName       用户名
     * @param password       密码
     * @param isSavePassword 是否记住密码
     */
    public static void saveLoginInfo(String userName, String password, boolean isSavePassword) {
        SPUtils.putString(SuperSPKey.USER_NAME, userName);
        SPUtils.putString(SuperSPKey.PASSWORD, isSavePassword ? password : "");
        SPUtils.putBoolean(SuperSPKey.SAVEPWD, isSavePassword);
        SPUtils.putBoolean(SPKey.IS_LOGINED, true);
        User curUser= new User();
        curUser.setId(userName);
        curUser.setName(userName);

        ImDbUtils.saveOrUpdateUser(curUser);
        User newUser= ImDbUtils.findUser(curUser);

        LogUtils.e("curUser:"+newUser.getId());
        LogUtils.e("curUser:"+newUser.getName());
    }

    public static String getUserName() {
        return SPUtils.getString(SuperSPKey.USER_NAME);
    }

    public static String getPassword() {
        return SPUtils.getString(SuperSPKey.PASSWORD);
    }

    public static boolean isSavePassword() {
        return SPUtils.getBoolean(SuperSPKey.SAVEPWD);
    }
}
