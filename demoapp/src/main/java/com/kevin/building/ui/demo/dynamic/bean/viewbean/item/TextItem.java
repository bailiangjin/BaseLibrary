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
