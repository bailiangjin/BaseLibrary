package com.bailiangjin.demo.demo.dynamic.view.base;

import android.content.Context;

import com.bailiangjin.demo.demo.dynamic.bean.viewbean.base.BaseItem;
import com.bailiangjin.demo.demo.dynamic.view.root.BaseView;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 14:07
 */
public abstract class BaseGridView extends BaseView {

    private List<BaseButton> btnList;

    public BaseGridView(Context context, BaseItem baseItem) {
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

    public List<BaseButton> getBtnList() {
        return btnList;
    }

    public void setBtnList(List<BaseButton> btnList) {
        this.btnList = btnList;
    }
}
