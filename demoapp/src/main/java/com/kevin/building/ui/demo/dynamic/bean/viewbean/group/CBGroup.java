package com.kevin.building.ui.demo.dynamic.bean.viewbean.group;

import com.kevin.building.ui.demo.dynamic.bean.viewbean.type.ViewType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.CBItem;

import java.util.List;

/**
 * CheckBox Group
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:09
 */
public class CBGroup extends BaseItem {

    private List<CBItem> cbList;

    public List<CBItem> getCbList() {

        return cbList;
    }

    public void setCbList(List<CBItem> cbList) {
        this.cbList = cbList;
    }

    @Override
    public void setDefaultViewType() {
        setViewType(ViewType.CB_GROUP);
    }
}
