package com.kevin.building.ui.demo.dynamic.bean.enumtype.view;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 14:07
 */
public class BaseGridView extends BaseView {

    private List<BaseButton> btnList;

    public List<BaseButton> getBtnList() {
        return btnList;
    }

    public void setBtnList(List<BaseButton> btnList) {
        this.btnList = btnList;
    }
}
