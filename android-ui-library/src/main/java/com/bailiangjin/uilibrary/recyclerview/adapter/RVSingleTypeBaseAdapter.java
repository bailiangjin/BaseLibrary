package com.bailiangjin.uilibrary.recyclerview.adapter;

import android.content.Context;

import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * 单种类型条目的 RecyclerViewBaseAdapter
 * Created by bailiangjin on 2016/12/20.
 */
public abstract class RVSingleTypeBaseAdapter<T> extends RVMultiTypeBaseAdapter<T> {



    public RVSingleTypeBaseAdapter(Context context) {
        super(context);
        addItemViewDelegate(new RVSingleTypeDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return getItemLayoutResId();
            }

            @Override
            public void convert(ViewHolder holder, T item, int position) {

                RVSingleTypeBaseAdapter.this.convert(holder,item,position);
            }
        });

    }



    protected abstract int getItemLayoutResId();

    protected abstract void convert(ViewHolder holder, T item, int position);
}
