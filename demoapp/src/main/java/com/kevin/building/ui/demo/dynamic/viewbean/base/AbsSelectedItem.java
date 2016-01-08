package com.kevin.building.ui.demo.dynamic.viewbean.base;

/**
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
