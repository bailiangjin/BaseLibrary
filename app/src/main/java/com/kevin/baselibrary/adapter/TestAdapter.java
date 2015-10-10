package com.kevin.baselibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.baselibrary.base.AbstractBaseAdapter;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/9 18:25
 */
public class TestAdapter extends AbstractBaseAdapter {
    public TestAdapter(Context context) {
        super(context);
    }

    public TestAdapter(Context context, List<String> list) {
        super(context);
        setListData(list);
    }


    @Override
    public View myGetView(int position, View convertView, ViewGroup viewGroup) {
        String itemStr = (String) mListData.get(position);

        View view = View.inflate(context, itemResId, null);


        return view;
    }

    @Override
    public int getItemLayoutResId() {
        return 0;
    }


}
