package com.kevin.building.demo.dynamic.bean.viewbean.item;

import com.kevin.building.demo.dynamic.bean.viewbean.type.ViewType;
import com.kevin.building.demo.dynamic.bean.viewbean.base.BaseItem;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 15:57
 */
public class TextItem extends BaseItem {

    /**
     * 文本样式类型
     */
    private int txtType;

    /**
     * 内容类型 普通文本/邮箱/密码 等等
     */
    private int contentType;

    public int getTxtType() {
        return txtType;
    }

    public void setTxtType(int txtType) {
        this.txtType = txtType;
    }


    @Override
    public void setDefaultViewType() {
        setViewType(ViewType.TEXT);
    }
}
