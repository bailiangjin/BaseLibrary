package com.kevin.building.ui.demo.dynamic.adapter;

import android.content.Context;

import com.kevin.building.R;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.BtnItem;

import java.util.List;

/**
 * 跳转页面按钮适配器
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/28 16:09
 */
public class BtnSkipGroupAdapter extends AbsBaseBtnGroupAdapter {


    public BtnSkipGroupAdapter(Context context, List<BtnItem> list) {
        super(context, list);
    }

    @Override
    protected int getItemLayoutResId() {
        return R.layout.item_btn_skip_gridview;
    }

    @Override
    protected int getItemTvResId() {
        return R.id.tv_name;
    }
}
