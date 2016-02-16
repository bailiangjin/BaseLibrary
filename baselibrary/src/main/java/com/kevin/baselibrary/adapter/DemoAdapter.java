package com.kevin.baselibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.baselibrary.base.SuperBaseAdapter;

import java.util.List;

/**
 * 示例Adapter 类
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/9 18:25
 */
public class DemoAdapter extends SuperBaseAdapter {


    public DemoAdapter(Context context, List<String> list) {
        super(context,list);
    }

    @Override
    public View myGetView(int position, View convertView, ViewGroup viewGroup) {
        String itemStr = (String) dataList.get(position);

        View view = View.inflate(context, itemResId, null);


        return view;
    }

    @Override
    public int getItemLayoutResId() {
        return 0;
    }


}
