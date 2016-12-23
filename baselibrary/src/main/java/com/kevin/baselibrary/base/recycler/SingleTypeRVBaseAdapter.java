package com.kevin.baselibrary.base.recycler;

import android.content.Context;

import com.kevin.baselibrary.base.recycler.delegate.YMRecyclerSingleTypeDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * 单种类型条目的 RecyclerViewBaseAdapter
 * Created by bailiangjin on 2016/12/20.
 */
public abstract class SingleTypeRVBaseAdapter<T> extends YMMultiItemTypeAdapter<T> {



    public SingleTypeRVBaseAdapter(Context context) {
        super(context);
        addItemViewDelegate(new YMRecyclerSingleTypeDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return getItemLayoutResId();
            }

            @Override
            public void convert(ViewHolder holder, T item, int position) {

                SingleTypeRVBaseAdapter.this.convert(holder,item,position);
            }
        });

    }



    protected abstract int getItemLayoutResId();

    protected abstract void convert(ViewHolder holder, T item, int position);
}
