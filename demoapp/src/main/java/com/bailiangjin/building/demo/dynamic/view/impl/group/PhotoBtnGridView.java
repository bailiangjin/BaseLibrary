package com.bailiangjin.building.demo.dynamic.view.impl.group;

import android.app.Activity;

import com.bailiangjin.building.demo.dynamic.DetailActivity;
import com.bailiangjin.building.demo.dynamic.adapter.AbsBaseBtnGroupAdapter;
import com.bailiangjin.building.demo.dynamic.adapter.BtnPhotoGroupAdapter;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.base.BaseItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.bailiangjin.building.demo.dynamic.callback.MyOnClickListener;
import com.bailiangjin.building.demo.dynamic.view.base.BaseGridViewNew;
import com.bailiangjin.building.utils.ActivityUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/28 15:52
 */
public class PhotoBtnGridView extends BaseGridViewNew {


    public PhotoBtnGridView(Activity context, BaseItem baseItem) {
        super(context, baseItem);
    }


    @Override
    protected MyOnClickListener getOnClickCallback(final Activity baseActivity, final List<BtnItem> btnItemList) {
        return new MyOnClickListener() {
            @Override
            public void onClick(int position) {
                BtnItem item = btnItemList.get(position);
                HashMap<String, String> paramMap = new HashMap<>();
                paramMap.put("name", item.getIndexText());
                ActivityUtils.startActivity(baseActivity, DetailActivity.class, paramMap);

            }
        };
    }

    @Override
    protected AbsBaseBtnGroupAdapter getAdapter(Activity context, List<BtnItem> btnItemList) {
        return new BtnPhotoGroupAdapter(baseActivity, btnItemList);
    }
}
