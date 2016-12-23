package com.kevin.baselibrary.base.recycler;

import android.content.Context;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bailiangjin on 2016/12/22.
 */

public class YMMultiItemTypeAdapter<T> extends MultiItemTypeAdapter<T> {

    public YMMultiItemTypeAdapter(Context context) {
        super(context, null);
        this.mDatas = new ArrayList<>();

    }

    public void setData(List<T> dataList) {
        if (null != mDatas) {
            mDatas.clear();
        } else {
            mDatas = new ArrayList<>();
        }

        if (null != dataList && !dataList.isEmpty()) {
            mDatas.addAll(dataList);
        }
    }

    public void addData(List<T> dataList) {
        if (null == mDatas) {
            mDatas = new ArrayList<>();
        }

        if (null != dataList && !dataList.isEmpty()) {
            this.mDatas.addAll(dataList);
        }
    }

    public void addData(T dataItem) {
        if (null == mDatas) {
            mDatas = new ArrayList<>();
        }

        if (null != dataItem) {
            this.mDatas.add(dataItem);
        }
    }

    public void removeData(T dataItem) {
        if (null == mDatas || mDatas.isEmpty()) {
            return;
        }
        if (mDatas.contains(dataItem)) {
            mDatas.remove(dataItem);
        }
    }
}
