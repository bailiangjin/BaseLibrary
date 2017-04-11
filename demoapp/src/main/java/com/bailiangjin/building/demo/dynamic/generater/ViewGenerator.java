package com.bailiangjin.building.demo.dynamic.generater;


import android.app.Activity;
import android.view.View;

import com.bailiangjin.building.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.group.CBGroup;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.group.RBGroup;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.TextItem;

/**
 *
 * View 生成器 接口
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/28 14:01
 */
public interface ViewGenerator {

    /**
     * 获取 文本条目View
     * @param context
     * @param textItem
     * @return
     */
    public View getTextView(Activity context, TextItem textItem);

    /**
     * 获取 输入框条目View
     * @param context
     * @param editTextItem
     * @return
     */
    public View getEditText(Activity context, EditTextItem editTextItem);

    /**
     * 获取 按钮条目View
     * @param context
     * @param btnItem
     * @return
     */
    public View getButton(Activity context, BtnItem btnItem);

    /**
     * 获取 跳转按钮组条目View
     * @param context
     * @param btnGroup
     * @return
     */
    public View getSkipBtnGroup(Activity context, BtnGroup btnGroup);

    /**
     * 获取 拍照按钮组条目View
     * @param context
     * @param btnGroup
     * @return
     */
    public View getPhotoBtnGroup(Activity context, BtnGroup btnGroup);

    /**
     * 获取 单选按钮组条目View
     * @param context
     * @param rbGroup
     * @return
     */
    public View getRbGroup(Activity context, RBGroup rbGroup);

    /**
     * 获取 多选按钮组条目View
     * @param context
     * @param cbGroup
     * @return
     */
    public View getCbGroup(Activity context, CBGroup cbGroup);
}
