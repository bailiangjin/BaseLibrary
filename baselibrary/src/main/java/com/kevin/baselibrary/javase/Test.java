package com.kevin.baselibrary.javase;

import com.kevin.baselibrary.javase.datastructure.HashArrayList;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/10 18:36
 */
public class Test {

    public static void main(String[] args) {
        HashArrayList list = new HashArrayList();
        HashArrayList list2 = new HashArrayList();

        list.add("test");
        list.add("test");
        list.add("test1");
        list.add("test1");
        list.add("test0");
        list.add("test0");
        list.add("test1");

        list2.add("test1");
        list2.add("test1");
        list2.add("test3");
        list2.add("test3");
        list2.add("test5");
        list2.add("test5");
        list2.add("test6");

        for (Object obj : list
                ) {
            System.out.print(" " + (String) obj + ":" + ((String) obj).hashCode());
        }
        System.out.println();

        for (Object obj : list2
                ) {
            System.out.print(" " + (String) obj + ":" + ((String) obj).hashCode());
        }
        System.out.println();
        list.addAll(0,list2);
        list.remove("test");

        for (Object obj : list
                ) {
            System.out.print(" "+(String) obj+":"+((String) obj).hashCode());
        }
    }
}
