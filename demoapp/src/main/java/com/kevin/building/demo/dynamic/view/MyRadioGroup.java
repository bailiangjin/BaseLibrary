package com.kevin.building.demo.dynamic.view;

import android.content.Context;

import com.kevin.building.demo.dynamic.bean.viewbean.base.BaseItem;
import com.kevin.building.demo.dynamic.view.base.BaseRadioButton;
import com.kevin.building.demo.dynamic.view.base.BaseView;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 15:34
 */
public class MyRadioGroup extends BaseView {

    private List<BaseRadioButton> rbList;

    public MyRadioGroup(Context context, BaseItem baseItem) {
        super(context, baseItem);
    }


    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initBase(BaseItem baseItem) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {

    }
}
