package com.kevin.baselibrary.utils;

import opensource.jpinyin.PinyinFormat;
import opensource.jpinyin.PinyinHelper;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/27 16:21
 */
public class PinyinUtils {


    /**
     * 分隔符
     */
    public static final String SEPARATOR = "";


    /**
     *  中文 转全拼拼音
     *
     * @param cnStr 中文
     * @return 全拼 拼音字符串
     */
    public static String chinese2Pinyin(String cnStr) {
        if (StringUtils.isEmpty(cnStr)) {
            return null;
        }
        return PinyinHelper.convertToPinyinString(cnStr, SEPARATOR, PinyinFormat.WITHOUT_TONE);
    }

    /**
     * 获取 首字母简拼
     * @param cnStr 中文
     * @return 首字母简拼字符串
     */
    public static String getShortPinyin(String cnStr) {
        if (StringUtils.isEmpty(cnStr)) {
            return null;
        }
        return PinyinHelper.getShortPinyin(cnStr);
    }
}
