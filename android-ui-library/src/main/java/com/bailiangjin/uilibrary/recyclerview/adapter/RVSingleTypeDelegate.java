package com.bailiangjin.uilibrary.recyclerview.adapter;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;

/**
 * 使用多种类型Adapter 定制单钟类型Adapter 专用的delegate
 * Created by bailiangjin on 16/12/20.
 */
public abstract class RVSingleTypeDelegate<T> implements ItemViewDelegate<T>
{

    @Override
    public boolean isForViewType(T item, int position)
    {
        //只有一种Item 返回true
        return true;
    }

}
