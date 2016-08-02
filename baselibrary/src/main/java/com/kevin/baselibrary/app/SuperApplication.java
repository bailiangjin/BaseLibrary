package com.kevin.baselibrary.app;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/9/8 00:09
 */
abstract public  class SuperApplication extends AbsSuperApplication {

    @Override
    protected String getAppNameFromSub() {
        return "baseLibrary";
    }
}
