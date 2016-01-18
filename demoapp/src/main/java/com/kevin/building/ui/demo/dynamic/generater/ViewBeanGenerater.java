package com.kevin.building.ui.demo.dynamic.generater;

import com.kevin.building.ui.demo.dynamic.viewbean.ViewBean;
import com.kevin.building.ui.demo.dynamic.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.viewbean.constants.ItemType;
import com.kevin.building.ui.demo.dynamic.viewbean.group.BtnGroup;
import com.kevin.building.ui.demo.dynamic.viewbean.item.TextItem;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/18 17:50
 */
public class ViewBeanGenerater {

    public static ViewBean getViewBean(BaseItem item) {
        ViewBean viewBean = new ViewBean();
        if (item instanceof TextItem) {
            viewBean.setTextItem((TextItem) item);
            viewBean.setItemType(ItemType.TEXT);
        } else if (item instanceof BtnGroup) {
            viewBean.setBtnGroup((BtnGroup) item);
            viewBean.setItemType(ItemType.BTN_GROUP);
        }

        return viewBean;

    }
}
