package com.bailiangjin.demo.jni;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/10/28 22:31
 */
public class NdkJniUtils {

    static {
        System.loadLibrary("testjni");	//defaultConfig.ndk.moduleName
    }

    public native String getCLanguageString();
}
