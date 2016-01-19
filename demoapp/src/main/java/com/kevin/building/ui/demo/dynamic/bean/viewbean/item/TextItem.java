package com.kevin.building.ui.demo.dynamic.bean.viewbean.item;

import com.kevin.building.ui.demo.dynamic.bean.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.constants.ViewType;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 15:57
 */
public class TextItem extends BaseItem {
    /**
     * 文本类型
     */
    private int txtType;

    /**
     * 居中17=Gravity.CENTER 靠左3=Gravity.LEFT 靠右5=Gravity.RIGHT
     */
    private  int gravity;

    /**
     * 文字大小 dp
     */
    private  int textSize;


    public int getTxtType() {
        return txtType;
    }

    public void setTxtType(int txtType) {
        this.txtType = txtType;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    @Override
    public void setDefaultViewType() {
        setViewType(ViewType.TEXT);
    }
}
