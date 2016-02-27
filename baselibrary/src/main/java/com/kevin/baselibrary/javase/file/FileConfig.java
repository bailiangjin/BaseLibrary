package com.kevin.baselibrary.javase.file;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：16/2/27 00:19
 */
public class FileConfig {

    /**
     * 文件片段大小 byte 50k
     */
    public static final int FRAGMENT_SIZE = 50*1024;

    /**
     * 配置文件首行 标题
     */
    public static final String fileNameKey ="fileName";
    /**
     * 文件片段 在配置文件中的索引Key 前缀
     */
    public static final String filePartNameKeyPrefix ="fragmentOrder";
    /**
     * 文件片段 后缀名
     */
    public static final String filePartSuffixKey =".fragment";
    /**
     * 文件片段总数key
     */
    public static final String filePartCountKey ="partCount";


    /**
     * 配置文件 文件名 不带后缀
     */
    public static final String propertiesFileName ="fileInfo";

    /**
     * 配置文件后缀名
     */
    public static final String propertiesFileSuffix ="properties";

    public static final String propertiesFileNameAll = propertiesFileName +"."+ propertiesFileSuffix;
}
