package com.kevin.baselibrary.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/9 18:23
 */
public abstract class SuperBaseAdapter<T> extends BaseAdapter {
    protected final Context context;
    protected final LayoutInflater mLayoutInflater;
    protected List<T> dataList;
    protected int itemResId = getItemLayoutResId();


    public SuperBaseAdapter(Context context,List<T> dataList) {
        this.context = context;
        this.dataList = dataList;
        mLayoutInflater = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList == null ? null : dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return myGetView(position, convertView, parent);
    }



    /**
     * get item layout ResId
     * @return int item layout resid
     */
    public abstract int getItemLayoutResId();


    public void setListData(List<T> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    /**
     * 抽象方法 获取View
     * @param position
     * @param convertView
     * @param viewGroup
     * @return
     */
    public abstract View myGetView(int position, View convertView, ViewGroup viewGroup);
}
