package com.kevin.building.ui.demo.dynamic.view.viewbean.item;

import com.kevin.building.ui.demo.dynamic.view.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.view.viewbean.constants.ViewType;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:00
 */
public class EditTextItem extends BaseItem {
    private String content;


    @Override
    public void setDefaultViewType() {
        setViewType(ViewType.ET);
    }


}
