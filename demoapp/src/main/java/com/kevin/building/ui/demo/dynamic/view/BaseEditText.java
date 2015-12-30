package com.kevin.building.ui.demo.dynamic.view;

import android.content.Context;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 15:32
 */
public class BaseEditText extends BaseView{

    private String info;

    private String hint;

    public BaseEditText(Context context) {
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
