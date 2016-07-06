package com.kevin.baselibrary.base;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * BaseAdapter for listView gridView
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/9 18:23
 */
public abstract class SuperBaseAdapter<T> extends BaseAdapter {
    protected final Context context;
    protected final LayoutInflater mLayoutInflater;
    protected List<T> dataList = new ArrayList<>();

    public SuperBaseAdapter(Activity activity, List<T> dataList) {
        this.context = activity;
        if (null != dataList && !dataList.isEmpty()) {
            this.dataList.clear();
            this.dataList.addAll(dataList);
        }
        mLayoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public T getItem(int position) {
        return dataList == null ? null : dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHelper viewHelper = new ViewHelper(convertView, parent).invoke();
        convertView = viewHelper.getConvertView();
        T item = getItem(position);
        Object holder = viewHelper.getHolder();
        setItemData(position,item, holder);
        return convertView;
    }

    public void setData(List<T> dataList) {
        if (null != dataList && !dataList.isEmpty()) {
            this.dataList.clear();
            this.dataList.addAll(dataList);
        }
    }


    /**
     * 获取 item layout ResId
     *
     * @return int item layout resid
     */
    public abstract int getItemLayoutResId();

    /**
     * 获取 ViewHolder ViewHolder自身实现初始化
     *
     * @param rootView
     * @return
     */
    public abstract Object getViewHolder(View rootView);

    /**
     * 设置item数据
     * @param position
     * @param dataItem
     * @param viewHolder
     */
    public abstract void setItemData(final int position,final T dataItem, final Object viewHolder);


    /**
     * 实现中间环节的调用辅助类
     */
    private class ViewHelper {
        private View convertView;
        private ViewGroup viewGroup;
        private Object holder;

        public ViewHelper(View convertView, ViewGroup viewGroup) {
            this.convertView = convertView;
            this.viewGroup = viewGroup;
        }

        public View getConvertView() {
            return convertView;
        }


        public Object getHolder() {
            return holder;
        }

        public ViewHelper invoke() {
            //covertView 复用的逻辑在这里呢  再也不用一遍一遍的写这个逻辑了
            if (convertView == null) {
                //新建 convertView
                convertView = mLayoutInflater.inflate(getItemLayoutResId(), viewGroup, false);
                holder = getViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                //复用 convertView
                holder = convertView.getTag();
            }
            return this;
        }
    }
}
