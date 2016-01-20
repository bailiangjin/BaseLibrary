package com.kevin.building.ui.demo.dynamic.bean.viewbean.group;

import com.kevin.building.ui.demo.dynamic.bean.viewbean.constants.ViewType;

/**
 * 按钮群组 GridView
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:12
 */
public class PhotoBtnGroup extends BtnGroup {

    @Override
    public void setDefaultViewType() {

        setViewType(ViewType.PHOTO_BTN_GROUP);
    }
}
