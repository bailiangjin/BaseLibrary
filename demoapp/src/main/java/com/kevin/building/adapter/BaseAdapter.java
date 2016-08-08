package com.kevin.building.adapter;

import android.app.Activity;

import com.kevin.baselibrary.base.SuperBaseAdapter;

import java.util.List;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：16/2/16 14:51
 */
public abstract class BaseAdapter extends SuperBaseAdapter {

    public BaseAdapter(Activity activity, List dataList) {
        super(activity, dataList);
    }
}
