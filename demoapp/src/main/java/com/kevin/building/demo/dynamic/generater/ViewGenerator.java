package com.kevin.building.demo.dynamic.generater;


import android.view.View;

import com.kevin.building.base.BaseActivity;
import com.kevin.building.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.group.CBGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.group.RBGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.TextItem;

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
    public View getTextView(BaseActivity context, TextItem textItem);

    /**
     * 获取 输入框条目View
     * @param context
     * @param editTextItem
     * @return
     */
    public View getEditText(BaseActivity context, EditTextItem editTextItem);

    /**
     * 获取 按钮条目View
     * @param context
     * @param btnItem
     * @return
     */
    public View getButton(BaseActivity context, BtnItem btnItem);

    /**
     * 获取 跳转按钮组条目View
     * @param context
     * @param btnGroup
     * @return
     */
    public View getSkipBtnGroup(BaseActivity context, BtnGroup btnGroup);

    /**
     * 获取 拍照按钮组条目View
     * @param context
     * @param btnGroup
     * @return
     */
    public View getPhotoBtnGroup(BaseActivity context, BtnGroup btnGroup);

    /**
     * 获取 单选按钮组条目View
     * @param context
     * @param rbGroup
     * @return
     */
    public View getRbGroup(BaseActivity context, RBGroup rbGroup);

    /**
     * 获取 多选按钮组条目View
     * @param context
     * @param cbGroup
     * @return
     */
    public View getCbGroup(BaseActivity context, CBGroup cbGroup);
}
