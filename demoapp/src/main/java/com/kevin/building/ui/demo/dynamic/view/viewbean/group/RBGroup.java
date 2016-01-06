package com.kevin.building.ui.demo.dynamic.view.viewbean.group;

import com.kevin.building.ui.demo.dynamic.view.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.view.viewbean.constants.ViewType;
import com.kevin.building.ui.demo.dynamic.view.viewbean.item.RBItem;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:08
 */
public class RBGroup extends BaseItem {

    private List<RBItem> rbList;

    public List<RBItem> getRbList() {
        return rbList;
    }

    public void setRbList(List<RBItem> rbList) {
        this.rbList = rbList;
    }

    @Override
    public void setDefaultViewType() {
        setViewType(ViewType.RB_Group);
    }
}
