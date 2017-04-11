package com.bailiangjin.demo.config;

import com.bailiangjin.utilslibrary.config.SuperBaseUrl;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/13 10:41
 */
public class Config {

    /**
     * 服务端IP
     */
    private static String IP="192.168.1.1";

    /**
     * 服务端端口
     */
    private static String PORT="8080";

    /**
     * 服务端 Url 前缀
     */
    private static String URL_PREFIX="http://";
    /**
     * 服务端 Url  后缀
     */
    private static String URL_POSTFIX="/IMWebServer";


    public static final String BASE_URL = new SuperBaseUrl(URL_PREFIX, IP, PORT, URL_POSTFIX).toString();
}
