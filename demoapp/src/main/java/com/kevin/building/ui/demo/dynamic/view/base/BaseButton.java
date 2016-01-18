package com.kevin.building.ui.demo.dynamic.view.base;

import android.content.Context;
import android.view.View;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 13:01
 */
public class BaseButton extends BaseView {

    private String text;
    private View.OnClickListener onClickListener;


    public BaseButton(Context context) {
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
