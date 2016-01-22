package com.kevin.building.ui.demo.dynamic.generater;

import com.kevin.building.ui.demo.dynamic.bean.constants.BtnGroupType;
import com.kevin.building.ui.demo.dynamic.bean.constants.ViewBeanType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.CBGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.RBGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.TextItem;

/**
 * ViewItem 包装类 将一个BaseItem 按类型包装为相应的 ViewItem
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/18 17:50
 */
public class ViewBeanGenerator {

    /**
     * 根据传入的BaseItem 对象类型 包装返回ViewBean对象
     *
     * @param item BaseItem
     * @return ViewItem
     */
    public static ViewItem getViewBean(BaseItem item) {
        ViewItem viewBean = new ViewItem();
        if (item instanceof TextItem) {
            viewBean.setTextItem((TextItem) item);
            viewBean.setViewItemType(ViewBeanType.TEXT);
        } else if (item instanceof EditTextItem) {
            viewBean.setEditTextItem((EditTextItem) item);
            viewBean.setViewItemType(ViewBeanType.ET);
        } else if (item instanceof BtnItem) {
            viewBean.setBtnItem((BtnItem) item);
            viewBean.setViewItemType(ViewBeanType.BTN);
        } else if (item instanceof BtnGroup) {
            BtnGroup btnGroup = (BtnGroup) item;
            viewBean.setBtnGroup(btnGroup);
            switch (btnGroup.getBtnGroupType()) {
                case BtnGroupType.SKIP_BTN_GROUP:
                    viewBean.setViewItemType(ViewBeanType.SKIP_BTN_GROUP);
                    break;
                case BtnGroupType.PHOTO_BTN_GROUP:
                    viewBean.setViewItemType(ViewBeanType.PHOTO_BTN_GROUP);
                    break;
                default:
                    viewBean.setViewItemType(ViewBeanType.SKIP_BTN_GROUP);
                    break;
            }

        } else if (item instanceof CBGroup) {
            viewBean.setCbGroup((CBGroup) item);
            viewBean.setViewItemType(ViewBeanType.CB_GROUP);
        } else if (item instanceof RBGroup) {
            viewBean.setRbGroup((RBGroup) item);
            viewBean.setViewItemType(ViewBeanType.RB_GROUP);
        }


        return viewBean;
    }
}
