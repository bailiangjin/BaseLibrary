package com.bailiangjin.demo.demo.dynamic.view.base;

import android.content.Context;

import com.bailiangjin.demo.demo.dynamic.bean.viewbean.base.BaseItem;
import com.bailiangjin.demo.demo.dynamic.view.root.BaseView;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 15:34
 */
public abstract class BaseCheckBox extends BaseView {


    public BaseCheckBox(Context context, BaseItem baseItem) {
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
