package com.kevin.building.ui.demo.dynamic.generater;

import android.support.annotation.NonNull;

import com.kevin.building.base.BaseActivity;
import com.kevin.building.ui.demo.dynamic.callback.ClickCallback;
import com.kevin.building.ui.demo.dynamic.DetailActivity;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.utils.ActivityUtils;

import java.util.HashMap;
import java.util.List;

/**
 *
 * 回调生成器 添加具体业务的处理
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/18 18:21
 */
public class CallBackGenerator {

    /**
     *  页面跳转 回调 具体处理逻辑在此处添加
     * @param activity
     * @param list
     * @return
     */
    @NonNull
    public static ClickCallback getSkipCallback(final BaseActivity activity, final List<BtnItem> list) {
        return new ClickCallback() {
            @Override
            public void onClick(int position) {
                BtnItem item = list.get(position);
                HashMap<String, String> paramMap = new HashMap<>();
                paramMap.put("name", item.getIndexText());
                ActivityUtils.startActivity(activity, DetailActivity.class, paramMap);

            }
        };
    }


}
