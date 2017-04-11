package com.bailiangjin.demo.demo.dynamic.bean.viewbean.item;

import com.bailiangjin.demo.demo.dynamic.bean.viewbean.type.ViewType;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.base.AbsSelectedItem;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:03
 */
public class RBItem extends AbsSelectedItem {

    @Override
    public void setDefaultViewType() {
        setViewType(ViewType.RB);
    }
}
