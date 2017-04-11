package com.bailiangjin.utilslibrary.config;

/**
 * @author 白良锦 bailiangjin@gmail.com
 * @version 创建时间：2015年10月12日 下午8:56:50
 */
public class SuperBaseUrl {

    /**
     * 服务端IP
     */
    private String IP;

    /**
     * 服务端端口
     */
    private String PORT;

    /**
     * 服务端 Url 前缀
     */
    private String URL_PREFIX;
    /**
     * 服务端 Url  后缀
     */
    private String URL_POSTFIX;


    /**
     * BaseUrl 类
     *
     * @param urlPrefix
     * @param ip
     * @param port
     * @param urlPostfix
     */
    public SuperBaseUrl(String urlPrefix, String ip, String port, String urlPostfix) {
        IP = ip;
        PORT = port;
        URL_PREFIX = urlPrefix;
        URL_POSTFIX = urlPostfix;
    }


    /**
     * 返回String字符串
     *
     * @return
     */
    @Override
    public String toString() {

        return URL_PREFIX + IP + ":" + PORT + URL_POSTFIX;
    }


}
