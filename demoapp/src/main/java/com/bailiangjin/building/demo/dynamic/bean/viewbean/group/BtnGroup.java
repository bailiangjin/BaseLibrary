package com.bailiangjin.building.demo.dynamic.bean.viewbean.group;

import com.bailiangjin.building.demo.dynamic.bean.viewbean.base.BaseItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.type.ViewType;

import java.util.List;

/**
 * 按钮群组 GridView
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:12
 */
public  class BtnGroup extends BaseItem {

    private int btnGroupType;

    private List<BtnItem> btnList;

    public List<BtnItem> getBtnList() {
        return btnList;
    }

    public void setBtnList(List<BtnItem> btnList) {
        this.btnList = btnList;
    }

    public int getBtnGroupType() {
        return btnGroupType;
    }

    public void setBtnGroupType(int btnGroupType) {
        this.btnGroupType = btnGroupType;
    }

    @Override
    public void setDefaultViewType() {

        setViewType(ViewType.BTN_GROUP);
    }


}
