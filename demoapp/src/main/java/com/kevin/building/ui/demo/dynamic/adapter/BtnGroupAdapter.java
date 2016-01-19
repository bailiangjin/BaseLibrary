package com.kevin.building.ui.demo.dynamic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kevin.building.R;
import com.kevin.building.ui.demo.dynamic.viewbean.item.BtnItem;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/28 16:09
 */
public class BtnGroupAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    private List<BtnItem> list;



    public BtnGroupAdapter(Context context, List<BtnItem> list){
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return null == list ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return null == list && !list.isEmpty() ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.item_essential_gridview, null);
        TextView mTextView = (TextView) convertView.findViewById(R.id.tv_name);
        mTextView.setText((CharSequence) list.get(position).getIndex());
        return convertView;
    }
}
