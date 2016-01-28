package com.kevin.building.demo.dynamic.generater;

import android.content.Context;
import android.view.View;
import android.widget.GridView;

import com.kevin.building.base.BaseActivity;
import com.kevin.building.demo.dynamic.adapter.BtnPhotoGroupAdapter;
import com.kevin.building.demo.dynamic.adapter.BtnSkipGroupAdapter;
import com.kevin.building.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.group.CBGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.group.RBGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.TextItem;
import com.kevin.building.demo.dynamic.bean.viewbean.type.TxtType;
import com.kevin.building.demo.dynamic.callback.ClickCallback;
import com.kevin.building.demo.dynamic.view.base.AbsBaseTextView;
import com.kevin.building.demo.dynamic.view.base.BaseButton;
import com.kevin.building.demo.dynamic.view.base.BaseEditText;
import com.kevin.building.demo.dynamic.view.textview.ClassNameTextView;
import com.kevin.building.demo.dynamic.view.textview.ContentTextView;
import com.kevin.building.demo.dynamic.view.textview.TitleTextView;

import java.util.List;

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
    public static BaseButton getButton(Context context,  BtnItem btnItem) {

        if (null == btnItem || null == context) {
            return null;
        }
        return new BaseButton(context, btnItem);
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
        return new BaseEditText(context, editTextItem);
    }

    /**
     * 生成文本元素
     *
     * @param context
     * @param textItem
     * @return
     */
    public static AbsBaseTextView getTextView(Context context,  TextItem textItem) {
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
     * @param baseActivity
     * @param btnGroup
     * @return
     */
    public static View getSkipBtnGroup(BaseActivity baseActivity, BtnGroup btnGroup) {

        if (null==btnGroup||null==baseActivity){
            return null;
        }
        GridView gridView;
        List<BtnItem> btnItemList = btnGroup.getBtnList();
        ClickCallback inesCallback = CallBackGenerator.getSkipCallback(baseActivity, btnItemList);
        gridView = ViewToolNonLogic.getGridView(baseActivity, inesCallback);
        gridView.setAdapter(new BtnSkipGroupAdapter(baseActivity, btnItemList));
        return gridView;
    }


    /**
     * 生成拍照按钮组
     *
     * @param baseActivity
     * @param btnGroup
     * @return
     */
    public static View getPhotoBtnGroup(BaseActivity baseActivity, BtnGroup btnGroup) {
        if (null==btnGroup||null==baseActivity){
            return null;
        }
        GridView gridView;
        List<BtnItem> btnItemList = btnGroup.getBtnList();
        ClickCallback inesCallback = CallBackGenerator.getSkipCallback(baseActivity, btnItemList);
        gridView = ViewToolNonLogic.getGridView(baseActivity, inesCallback);
        gridView.setAdapter(new BtnPhotoGroupAdapter(baseActivity, btnItemList));
        return gridView;
    }


    /**
     * 生成单选按钮组
     *
     * @param context
     * @param rbGroup
     * @return
     */
    public static View getRbGroup(Context context, RBGroup rbGroup) {
        if (null==rbGroup||null==context){
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

        if (null==cbGroup||null==context){
            return null;
        }
        return null;
    }


}
