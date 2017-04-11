package com.bailiangjin.building.demo.dynamic.bean.viewbean.base;

/**
 * Item基类 具体Item包括GroupItem 都是BaseItem的子类
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:05
 */
public abstract class AbsSelectedItem extends BaseItem{
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
