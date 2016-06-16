package com.kevin.baselibrary.javase;

import android.net.Uri;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/10 18:36
 */
public class Test {

    public static void main(String[] args) {
//        ThreeLevelCache<String> threeLevelCache= ThreeLevelCache.getInstance();
//        threeLevelCache.put("1","1");
//
//        ThreeLevelCache<Integer> threeLevelCache2= ThreeLevelCache.getInstance();
//        threeLevelCache2.put("1",2);
//
//        System.out.println(threeLevelCache.get("1",String.class));
//        System.out.println(threeLevelCache2.get("1",Integer.class));


        System.out.println(Uri.encode("hxid=did_68245897,doctorid=93,doctorname=老徐,headurl=http://xs3.op.xywy.com/oss.wenkang.cn/oss_family_doctor_picture_1464845846.jpg"));
    }
}
