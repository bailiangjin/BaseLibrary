package com.kevin.building.ui.demo.dynamic.view.viewbean.group;

import com.kevin.building.ui.demo.dynamic.view.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.view.viewbean.constants.ViewType;
import com.kevin.building.ui.demo.dynamic.view.viewbean.item.BtnItem;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:12
 */
public class BtnGroup extends BaseItem{

    private List<BtnItem> btnList;

    public List<BtnItem> getBtnList() {
        return btnList;
    }

    public void setBtnList(List<BtnItem> btnList) {
        this.btnList = btnList;
    }

    @Override
    public void setDefaultViewType() {
        setViewType(ViewType.BTN_GROUP);
    }
}
