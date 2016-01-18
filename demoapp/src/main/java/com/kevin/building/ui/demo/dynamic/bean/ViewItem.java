package com.kevin.building.ui.demo.dynamic.bean;

import com.kevin.building.ui.demo.dynamic.view.BaseEditText;
import com.kevin.building.ui.demo.dynamic.view.BaseGridView;
import com.kevin.building.ui.demo.dynamic.view.BaseTextView;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 12:57
 */
public class ViewItem {

    private int itemType;

    private BaseGridView gridView;

    private BaseTextView baseTextView;

    private BaseEditText baseEditText;


    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public BaseGridView getGridView() {
        return gridView;
    }

    public void setGridView(BaseGridView gridView) {
        this.gridView = gridView;
    }

    public BaseTextView getBaseTextView() {
        return baseTextView;
    }

    public void setBaseTextView(BaseTextView baseTextView) {
        this.baseTextView = baseTextView;
    }
}
