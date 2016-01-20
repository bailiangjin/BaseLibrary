package com.kevin.building.ui.demo.dynamic.generater;

import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewBean;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.constants.ItemType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.CBGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.PhotoBtnGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.RBGroup;
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
        ViewBean viewBean = new ViewBean();
        if (item instanceof TextItem) {
            viewBean.setTextItem((TextItem) item);
            viewBean.setItemType(ItemType.TEXT);
        } else if (item instanceof EditTextItem) {
            viewBean.setEditTextItem((EditTextItem) item);
            viewBean.setItemType(ItemType.ET);
        } else if (item instanceof BtnItem) {
            viewBean.setBtnItem((BtnItem) item);
            viewBean.setItemType(ItemType.BTN);
        } else if (item instanceof PhotoBtnGroup) {
            viewBean.setBtnGroup((BtnGroup) item);
            viewBean.setItemType(ItemType.PHOTO_BTN_GROUP);
        } else if (item instanceof BtnGroup) {
            viewBean.setBtnGroup((BtnGroup) item);
            viewBean.setItemType(ItemType.BTN_GROUP);
        } else if (item instanceof CBGroup) {
            viewBean.setCbGroup((CBGroup) item);
            viewBean.setItemType(ItemType.CB_GROUP);
        } else if (item instanceof RBGroup) {
            viewBean.setRbGroup((RBGroup) item);
            viewBean.setItemType(ItemType.RB_GROUP);
        }


        return viewBean;
    }
}
