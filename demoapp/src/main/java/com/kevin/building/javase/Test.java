package com.kevin.building.javase;

import com.kevin.baselibrary.utils.PinyinUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/10 18:36
 */
public class Test {

    public static void main(String[] args) {
        testPinyin();
        testTimes(5);
    }

    private static void testPinyin(){
        System.out.println("转换结果:" + PinyinUtils.chinese2Pinyin("中国好声音"));
    }

    private static void testTimes(int n){
        int i=1;int j=n;int x=0;

        while (i<j){
            System.out.println("i="+i+" j="+j+" x="+x);
            i++;j--;x+=2;

        }

        System.out.println("x="+x);

    }
}
