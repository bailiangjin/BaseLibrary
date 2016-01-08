package com.kevin.building.ui.demo.dynamic.viewbean.group;

import com.kevin.building.ui.demo.dynamic.viewbean.base.AbsGroup;
import com.kevin.building.ui.demo.dynamic.viewbean.constants.ViewType;
import com.kevin.building.ui.demo.dynamic.viewbean.item.CBItem;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:09
 */
public class CBGroup extends AbsGroup {

    private List<CBItem> cbList;

    public List<CBItem> getCbList() {

        return cbList;
    }

    public void setCbList(List<CBItem> cbList) {
        this.cbList = cbList;
    }

    @Override
    public void setDefaultViewType() {
        setViewType(ViewType.CB_Group);
    }
}
