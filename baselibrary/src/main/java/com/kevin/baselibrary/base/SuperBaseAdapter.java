package com.kevin.baselibrary.base;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kevin.baselibrary.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bailiangjin on 16/8/1.
 */
abstract public class SuperBaseAdapter<T> extends BaseAdapter {

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
        View view;
        BaseViewHolder holder;
        if (convertView == null) {
            view = View.inflate(context, getItemLayoutResId(), null);
            holder = getViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (BaseViewHolder) view.getTag();
        }
        holder.show(position);
        return view;
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
    protected abstract BaseViewHolder getViewHolder(View rootView);

    /**
     * ViewHolder基类
     */
    public abstract class BaseViewHolder<T> {
        public View rootView;

        public BaseViewHolder(View rootView) {
            this.rootView = rootView;
        }

        public void show(int position) {
            T data= (T) dataList.get(position);
            if(null==data){
                LogUtils.e("条目数据未初始化");
                return;
            }
            show(position,data);
        }

        public abstract void show(int position,T data);

    }

}
