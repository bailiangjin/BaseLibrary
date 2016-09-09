package com.kevin.building.demo.dynamic.generater;

import android.app.Activity;
import android.view.View;

import com.kevin.building.demo.dynamic.bean.viewbean.ViewBean;
import com.kevin.building.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.group.CBGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.group.RBGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.TextItem;
import com.kevin.building.demo.dynamic.bean.viewbean.type.ViewBeanType;

/**
 * View生成器 实例
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/28 14:14
 */
public class ViewGeneratorImpl implements ViewGenerator {

    /**
     * 生成的View
     */
    private View view;


    public ViewGeneratorImpl(Activity context, ViewBean viewBean) {
        int itemType = viewBean.getViewItemType();
        switch (itemType) {
            case ViewBeanType.TEXT:
                this.view = getTextView(context, viewBean.getTextItem());
                break;

            case ViewBeanType.SKIP_BTN_GROUP:
                this.view = getSkipBtnGroup(context, viewBean.getBtnGroup());
                break;

            case ViewBeanType.PHOTO_BTN_GROUP:
                this.view = getPhotoBtnGroup(context, viewBean.getBtnGroup());
                break;

            case ViewBeanType.ET:
                this.view = getEditText(context, viewBean.getEditTextItem());
                break;

            case ViewBeanType.BTN:
                this.view = getButton(context, viewBean.getBtnItem());
                break;

            case ViewBeanType.RB_GROUP:
                this.view = getRbGroup(context, viewBean.getRbGroup());
                break;

            case ViewBeanType.CB_GROUP:
                this.view = getCbGroup(context, viewBean.getCbGroup());
                break;

            default:
                this.view = null;
                break;
        }
    }

    /**
     * 获取生成的View
     *
     * @return View
     */
    public View getView() {
        return view;
    }


    @Override
    public View getTextView(Activity context, TextItem textItem) {
        return ViewTools.getTextView(context, textItem);

    }

    @Override
    public View getEditText(Activity context, EditTextItem editTextItem) {
        return ViewTools.getEditText(context, editTextItem);
    }

    @Override
    public View getButton(Activity context, BtnItem btnItem) {
        return ViewTools.getButton(context, btnItem);
    }

    @Override
    public View getSkipBtnGroup(Activity context, BtnGroup btnGroup) {
        return ViewTools.getSkipBtnGroup(context, btnGroup);
    }

    @Override
    public View getPhotoBtnGroup(Activity context, BtnGroup btnGroup) {
        return ViewTools.getPhotoBtnGroup(context, btnGroup);
    }

    @Override
    public View getRbGroup(Activity context, RBGroup rbGroup) {
        return ViewTools.getRbGroup(context, rbGroup);
    }

    @Override
    public View getCbGroup(Activity context, CBGroup cbGroup) {
        return ViewTools.getCbGroup(context, cbGroup);
    }
}
