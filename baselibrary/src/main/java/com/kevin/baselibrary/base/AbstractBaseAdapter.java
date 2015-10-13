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
public abstract class AbstractBaseAdapter<T> extends BaseAdapter {
    protected final Context context;
    protected final LayoutInflater mLayoutInflater;
    protected List<T> mListData;
    protected int itemResId = getItemLayoutResId();

    public AbstractBaseAdapter(Context context) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return mListData == null ? 0 : mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData == null ? null : mListData.get(position);
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


    public void setListData(List<T> mListData) {
        this.mListData = mListData;
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
