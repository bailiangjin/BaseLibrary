package com.kevin.building.ui.demo.dynamic.bean.viewbean.item;

import com.kevin.building.ui.demo.dynamic.bean.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.constants.ViewType;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:02
 */
public class BtnItem extends BaseItem {

    /**
     * 按钮类型
     */
    private int btnType;
    /**
     * 定位类型
     */
    private int locationType;

    /**
     * 照片压缩方式
     */
    private int compressType;

    /**
     * 按钮背景颜色
     */
    private int  bkgColor ;


    @Override
    public void setDefaultViewType() {
        setViewType(ViewType.BTN);
    }

    public int getBtnType() {
        return btnType;
    }

    public void setBtnType(int btnType) {
        this.btnType = btnType;
    }

    public int getLocationType() {
        return locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
    }

    public int getCompressType() {
        return compressType;
    }

    public void setCompressType(int compressType) {
        this.compressType = compressType;
    }

    public int getBkgColor() {
        return bkgColor;
    }

    public void setBkgColor(int bkgColor) {
        this.bkgColor = bkgColor;
    }
}
