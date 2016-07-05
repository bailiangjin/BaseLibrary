package com.kevin.baselibrary.adapter;

import android.app.Activity;
import android.view.View;


import com.kevin.baselibrary.base.SuperBaseAdapter;

import java.util.List;

/**
 * 示例Adapter 类
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/9 18:25
 */
public class DemoAdapter extends SuperBaseAdapter {


    public DemoAdapter(Activity context, List<String> list) {
        super(context,list);
    }



    @Override
    public int getItemLayoutResId() {
        return 0;
    }

    @Override
    public Object getViewHolder(View rootView) {
        return null;
    }

    @Override
    public void setItemData(Object dataItem, Object viewHolder) {

    }


}
