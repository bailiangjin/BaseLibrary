package com.kevin.building.ui.demo.dynamic.view;

import android.content.Context;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 15:34
 */
public class BaseRideoGroup extends BaseView{

    private List<BaseRadieoButton> rdbtnList;


    public BaseRideoGroup(Context context) {
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
