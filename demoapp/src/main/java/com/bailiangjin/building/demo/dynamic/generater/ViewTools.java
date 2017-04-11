package com.bailiangjin.building.demo.dynamic.generater;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.bailiangjin.building.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.group.CBGroup;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.group.RBGroup;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.TextItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.type.BtnType;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.type.TxtType;
import com.bailiangjin.building.demo.dynamic.view.base.BaseButton;
import com.bailiangjin.building.demo.dynamic.view.base.BaseEditText;
import com.bailiangjin.building.demo.dynamic.view.base.BaseTextView;
import com.bailiangjin.building.demo.dynamic.view.impl.button.SaveButton;
import com.bailiangjin.building.demo.dynamic.view.impl.et.CommonEditText;
import com.bailiangjin.building.demo.dynamic.view.impl.group.PhotoBtnGridView;
import com.bailiangjin.building.demo.dynamic.view.impl.group.SkipBtnGridView;
import com.bailiangjin.building.demo.dynamic.view.impl.textview.ClassNameTextView;
import com.bailiangjin.building.demo.dynamic.view.impl.textview.ContentTextView;
import com.bailiangjin.building.demo.dynamic.view.impl.textview.TitleTextView;

/**
 * ViewBean 动态解析器 用于将ViewBean解析为相应的View 并返回
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 10:39
 */
public class ViewTools {

    /**
     * 生成按钮元素
     *
     * @param context
     * @param btnItem
     * @return
     */
    public static BaseButton getButton(Context context, BtnItem btnItem) {

        if (null == btnItem || null == context) {
            return null;
        }

        switch (btnItem.getBtnType()) {
            case BtnType.SAVE:
                return new SaveButton(context, btnItem);
            default:
                return null;
        }

    }


    /**
     * 生成输入框
     *
     * @param context
     * @param editTextItem
     * @return
     */
    public static BaseEditText getEditText(Context context, EditTextItem editTextItem) {
        if (null == editTextItem || null == context) {
            return null;
        }
        return new CommonEditText(context, editTextItem);
    }

    /**
     * 生成文本元素
     *
     * @param context
     * @param textItem
     * @return
     */
    public static BaseTextView getTextView(Context context, TextItem textItem) {
        if (null == textItem || null == context) {
            return null;
        }
        switch (textItem.getTxtType()) {
            case TxtType.TITLE:
                return new TitleTextView(context, textItem);

            case TxtType.CLASS_NAME:
                return new ClassNameTextView(context, textItem);

            case TxtType.CONTENT:
                return new ContentTextView(context, textItem);

            default:
                return null;
        }
    }


    /**
     * 生成跳转按钮组
     *
     * @param context
     * @param btnGroup
     * @return
     */
    public static View getSkipBtnGroup(Activity context, BtnGroup btnGroup) {

        if (null == btnGroup || null == context) {
            return null;
        }

        return new SkipBtnGridView(context, btnGroup);
    }


    /**
     * 生成拍照按钮组
     *
     * @param context
     * @param btnGroup
     * @return
     */
    public static View getPhotoBtnGroup(Activity context, BtnGroup btnGroup) {
        if (null == btnGroup || null == context) {
            return null;
        }

        return new PhotoBtnGridView(context, btnGroup);
    }


    /**
     * 生成单选按钮组
     *
     * @param context
     * @param rbGroup
     * @return
     */
    public static View getRbGroup(Context context, RBGroup rbGroup) {
        if (null == rbGroup || null == context) {
            return null;
        }
        return null;
    }

    /**
     * 生成多选按钮组
     *
     * @param context
     * @param cbGroup
     * @return
     */
    public static View getCbGroup(Context context, CBGroup cbGroup) {

        if (null == cbGroup || null == context) {
            return null;
        }
        return null;
    }


}
