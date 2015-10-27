package com.kevin.building.test;

import com.kevin.baselibrary.utils.PinyinUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/10 18:36
 */
public class Test {

    public static void main(String[] args) {
        testPinyin();
    }

    private static void testPinyin(){
        System.out.println("pinyin" + PinyinUtils.chinese2Pinyin("中国好声音"));
    }
}
