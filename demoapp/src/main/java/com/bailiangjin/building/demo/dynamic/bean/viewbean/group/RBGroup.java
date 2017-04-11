package com.bailiangjin.building.demo.dynamic.bean.viewbean.group;

import com.bailiangjin.building.demo.dynamic.bean.viewbean.base.BaseItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.RBItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.type.ViewType;

import java.util.List;

/**
 * RadioButton Group
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
        setViewType(ViewType.RB_GROUP);
    }
}
