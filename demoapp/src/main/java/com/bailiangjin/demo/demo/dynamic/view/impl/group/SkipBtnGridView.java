package com.bailiangjin.demo.demo.dynamic.view.impl.group;

import android.app.Activity;

import com.bailiangjin.demo.demo.dynamic.DetailActivity;
import com.bailiangjin.demo.demo.dynamic.adapter.AbsBaseBtnGroupAdapter;
import com.bailiangjin.demo.demo.dynamic.adapter.BtnSkipGroupAdapter;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.base.BaseItem;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.item.BtnItem;
import com.bailiangjin.demo.demo.dynamic.callback.MyOnClickListener;
import com.bailiangjin.demo.demo.dynamic.view.base.BaseGridViewNew;
import com.bailiangjin.demo.utils.ActivityUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/28 15:52
 */
public class SkipBtnGridView extends BaseGridViewNew {


    public SkipBtnGridView(Activity context, BaseItem baseItem) {
        super(context, baseItem);
    }


    @Override
    protected MyOnClickListener getOnClickCallback(final Activity context, final List<BtnItem> btnItemList) {
        return new MyOnClickListener() {
            @Override
            public void onClick(int position) {
                BtnItem item = btnItemList.get(position);
                HashMap<String, String> paramMap = new HashMap<>();
                paramMap.put("name", item.getIndexText());
                ActivityUtils.startActivity(context, DetailActivity.class, paramMap);

            }
        };
    }

    @Override
    protected AbsBaseBtnGroupAdapter getAdapter(Activity context, List<BtnItem> btnItemList) {
        return new BtnSkipGroupAdapter(context, btnItemList);
    }
}
