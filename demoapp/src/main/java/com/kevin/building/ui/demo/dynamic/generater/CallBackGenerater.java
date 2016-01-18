package com.kevin.building.ui.demo.dynamic.generater;

import android.support.annotation.NonNull;

import com.kevin.building.base.BaseActivity;
import com.kevin.building.ui.demo.dynamic.ClickCallback;
import com.kevin.building.ui.demo.dynamic.DetailActivity;
import com.kevin.building.ui.demo.dynamic.viewbean.item.BtnItem;
import com.kevin.building.utils.ActivityUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/18 18:21
 */
public class CallBackGenerater {

    @NonNull
    public static ClickCallback getClickCallback(final BaseActivity activity, final List<BtnItem> list) {
        return new ClickCallback() {
            @Override
            public void onClick(int position) {
                BtnItem item = list.get(position);
                HashMap<String, String> paramMap = new HashMap<>();
                paramMap.put("name", item.getIndex());
                ActivityUtils.startActivity(activity, DetailActivity.class, paramMap);

            }
        };
    }

    @NonNull
    public static ClickCallback getClickCallback1(final BaseActivity activity, final List<BtnItem> list) {
        return new ClickCallback() {
            @Override
            public void onClick(int position) {
                BtnItem item = list.get(position);
                HashMap<String, String> paramMap = new HashMap<>();
                paramMap.put("name", item.getIndex());
                ActivityUtils.startActivity(activity, DetailActivity.class, paramMap);

            }
        };
    }
}
