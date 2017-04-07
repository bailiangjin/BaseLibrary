package com.bailiangjin.uilibrary.fragment.listfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bailiangjin.uilibrary.R;
import com.bailiangjin.uilibrary.fragment.SuperBaseFragment;
import com.bailiangjin.uilibrary.recyclerview.adapter.HSItemDecoration;
import com.bailiangjin.uilibrary.recyclerview.adapter.RVMultiTypeBaseAdapter;


/**
 * Created by bailiangjin on 2017/3/22.
 */

public abstract class ListFragment<T extends RVMultiTypeBaseAdapter> extends SuperBaseFragment {


    RecyclerView recyclerView;

    protected T listRvAdapter;

    protected RecyclerView.Adapter realAdapter;

    protected boolean isDecorationAdded = false;





    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_with_rv_list;
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        recyclerView= (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (!isDecorationAdded) {
            recyclerView.addItemDecoration(getItemDecoration());
            isDecorationAdded = true;
        }
        listRvAdapter = getListRvAdapter();
        realAdapter = listRvAdapter;
        initRefresh();
    }


    /**
     * 获取分割线样式
     *
     * @return
     */
    private HSItemDecoration getItemDecoration() {

        if (getDividerLineWidth() >=0 && getDividerColorResId() > 0) {
            return new HSItemDecoration(getActivity(), getDividerColorResId(), getDividerLineWidth());
        } else if (getDividerLineWidth() >= 0) {
            return new HSItemDecoration(getActivity(), getDividerLineWidth());
        } else if (getDividerColorResId() > 0) {
            return new HSItemDecoration(getActivity(), getDividerColorResId());
        } else {
            return new HSItemDecoration(getActivity());
        }
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        initLoadMore();
        recyclerView.setAdapter(realAdapter);
    }

    protected void notifyAdapterDataChanged() {

        if (null != realAdapter) {
            realAdapter.notifyDataSetChanged();
        }

    }

    protected void setAdapter(T adapter) {
        listRvAdapter = adapter;
    }



    protected void initRefresh() {

    }


    protected void initLoadMore() {
    }

    protected abstract T getListRvAdapter();


    /**
     * 自定义分割线宽度
     *
     * @return
     */
    protected float getDividerLineWidth() {
        return -1;
    }

    /**
     * 自定义分隔线颜色 返回color的resId
     *
     * @return
     */
    protected int getDividerColorResId() {
        return 0;
    }


}
