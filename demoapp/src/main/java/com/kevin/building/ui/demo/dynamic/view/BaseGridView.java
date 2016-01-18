package com.kevin.building.ui.demo.dynamic.view;

import android.content.Context;

import com.kevin.building.ui.demo.dynamic.view.base.BaseButton;
import com.kevin.building.ui.demo.dynamic.view.base.BaseView;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 14:07
 */
public class BaseGridView extends BaseView {

    private List<BaseButton> btnList;

    public BaseGridView(Context context) {
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

    public List<BaseButton> getBtnList() {
        return btnList;
    }

    public void setBtnList(List<BaseButton> btnList) {
        this.btnList = btnList;
    }
}
