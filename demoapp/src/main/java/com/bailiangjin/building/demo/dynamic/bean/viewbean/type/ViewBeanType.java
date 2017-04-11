package com.bailiangjin.building.demo.dynamic.bean.viewbean.type;

/**
 * ViewBean 实际条目类型类：基于基本元素组合扩展出的实际使用类型类
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 17:08
 */
public class ViewBeanType {

    /**
     * 文本
     */
    public static final int TEXT = 0;

    /**
     * 输入框
     */
    public static final int ET = 1;

    /**
     * 按钮
     */
    public static final int BTN = 2;

    /**
     * RadioButton Group
     *
     */
    public static final int RB_GROUP = 3;

    /**
     * CheckBox Group
     */
    public static final int CB_GROUP = 4;

    /**
     * 跳转按钮 列表 基于基本元素类型 ViewType.BTN_GROUP 扩展出的具体类型
     */
    public static final int SKIP_BTN_GROUP = 5;

    /**
     * 拍照按钮 列表 基于基本元素类型 ViewType.BTN_GROUP 扩展出的具体类型
     */
    public static final int PHOTO_BTN_GROUP = 6;
}
