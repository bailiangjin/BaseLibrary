package com.kevin.building.ui.demo.dynamic;

import android.view.View;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/28 14:24
 */
public class EssentialItem {
    private ItemType itemType;
    private String txtName;
    private boolean selected;
    private View.OnClickListener onClickListener;

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
