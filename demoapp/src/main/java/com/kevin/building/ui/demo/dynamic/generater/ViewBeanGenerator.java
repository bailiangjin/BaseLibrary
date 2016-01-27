package com.kevin.building.ui.demo.dynamic.generater;

import com.kevin.building.ui.demo.dynamic.bean.viewbean.type.BtnGroupType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.type.ViewBeanType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewBean;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.CBGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.RBGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.TextItem;

/**
 * ViewBean 包装类 将一个BaseItem 按类型包装为相应的 ViewBean
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/18 17:50
 */
public class ViewBeanGenerator {

    /**
     * 根据传入的BaseItem 对象类型 包装返回ViewBean对象
     *
     * @param item BaseItem
     * @return ViewBean
     */
    public static ViewBean getViewBean(BaseItem item) {
        ViewBean viewItem = new ViewBean();
        if (item instanceof TextItem) {
            viewItem.setTextItem((TextItem) item);
            viewItem.setViewItemType(ViewBeanType.TEXT);
        } else if (item instanceof EditTextItem) {
            viewItem.setEditTextItem((EditTextItem) item);
            viewItem.setViewItemType(ViewBeanType.ET);
        } else if (item instanceof BtnItem) {
            viewItem.setBtnItem((BtnItem) item);
            viewItem.setViewItemType(ViewBeanType.BTN);
        } else if (item instanceof BtnGroup) {
            BtnGroup btnGroup = (BtnGroup) item;
            viewItem.setBtnGroup(btnGroup);
            switch (btnGroup.getBtnGroupType()) {
                case BtnGroupType.SKIP_BTN_GROUP:
                    viewItem.setViewItemType(ViewBeanType.SKIP_BTN_GROUP);
                    break;
                case BtnGroupType.PHOTO_BTN_GROUP:
                    viewItem.setViewItemType(ViewBeanType.PHOTO_BTN_GROUP);
                    break;
                default:
                    viewItem.setViewItemType(ViewBeanType.SKIP_BTN_GROUP);
                    break;
            }

        } else if (item instanceof CBGroup) {
            viewItem.setCbGroup((CBGroup) item);
            viewItem.setViewItemType(ViewBeanType.CB_GROUP);
        } else if (item instanceof RBGroup) {
            viewItem.setRbGroup((RBGroup) item);
            viewItem.setViewItemType(ViewBeanType.RB_GROUP);
        }


        return viewItem;
    }
}
