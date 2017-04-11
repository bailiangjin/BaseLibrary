package com.bailiangjin.building.demo.dynamic.view.base;

import android.content.Context;
import android.widget.TextView;

import com.bailiangjin.building.R;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.base.BaseItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.bailiangjin.building.demo.dynamic.view.root.BaseView;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 13:01
 */
public abstract class BaseButton extends BaseView {

    private TextView tv_index;

    private BtnItem btnItem;

    public BaseButton(Context context, BaseItem baseItem) {
        super(context, baseItem);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.ctn_button;
    }

    @Override
    protected void initBase(BaseItem baseItem) {
        btnItem= (BtnItem) baseItem;
    }

    @Override
    protected void initView() {
        tv_index= (TextView) findViewById(R.id.tv_index);

        tv_index.setText(btnItem.getIndexText());

    }

    @Override
    protected void initLogic() {

    }
}
