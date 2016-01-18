package com.kevin.building.ui.demo.dynamic.view;

import android.content.Context;

import com.kevin.building.ui.demo.dynamic.view.base.BaseView;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 15:34
 */
public class MyRadioGroup extends BaseView {

    private List<BaseRadioButton> rbList;


    public MyRadioGroup(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {

    }
}
