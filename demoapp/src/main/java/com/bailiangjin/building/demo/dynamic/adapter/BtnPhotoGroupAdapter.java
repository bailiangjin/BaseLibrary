package com.bailiangjin.building.demo.dynamic.adapter;

import android.content.Context;

import com.bailiangjin.building.R;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.BtnItem;

import java.util.List;

/**
 * 拍照按钮适配器
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/28 16:09
 */
public class BtnPhotoGroupAdapter extends AbsBaseBtnGroupAdapter {


    public BtnPhotoGroupAdapter(Context context, List<BtnItem> list) {
        super(context, list);
    }

    @Override
    protected int getItemLayoutResId() {
        return R.layout.item_btn_photo_gridview;
    }

    @Override
    protected int getItemTvResId() {
        return R.id.tv_name;
    }
}
