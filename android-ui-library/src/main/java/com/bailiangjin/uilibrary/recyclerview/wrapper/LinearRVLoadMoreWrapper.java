package com.bailiangjin.uilibrary.recyclerview.wrapper;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.bailiangjin.uilibrary.R;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

/**
 *  RecyclerView list 布局 加载更多包装器 解决 baseadapter 库中 首次加载触发加载更多问题
 * Created by bailiangjin on 2017/2/7.
 */

public class LinearRVLoadMoreWrapper<T> extends LoadMoreWrapper<T> {
    protected RecyclerView recyclerView;


    protected LoadMoreAndNoMoreDataCallback loadMoreAndNoMoreDataCallback;


    public LinearRVLoadMoreWrapper(RecyclerView.Adapter adapter, RecyclerView recyclerView) {
        super(adapter);
        if (null == recyclerView || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            throw new RuntimeException("recyclerView is null or the layoutManager of recyclerview is not instance of LinearLayoutManager");
        }
        this.recyclerView = recyclerView;
        setDefaultLoadMoreView(recyclerView.getContext());
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isShowLoadMore(position)) {

            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
            Log.d("LinearRVLoadMoreWrapper","loadMoreWrapper:itemcount:" + getItemCount() + "   lastVisiblePosition:" + lastVisiblePosition + "  gap:" + (getItemCount() - lastVisiblePosition));
            if (1 == getItemCount()) {
                //初始状态
                showLoadMore();
            } else {
                int gap = getItemCount() - lastVisiblePosition;
                //正常lastVisiblePosition 的值比ItemCount小2 但有时loadMoreView 未完全显示 此时小3
                //滑动过快时 gap值最大可能为4 待研究

                // 有时显示了数据 lastVisiblePosition 却为 -1 这个问题待研究
                if ((gap<=4) || -1 == lastVisiblePosition) {
                    //加载更多
                    if (mOnLoadMoreListener != null) {
                        Log.d("LinearRVLoadMoreWrapper", "onLoadMore");
                        showLoadMore();
                        mOnLoadMoreListener.onLoadMoreRequested();
                    }
                }
//                } else {
//                    showNoMoreData();
//                }
            }


            return;
        }
        mInnerAdapter.onBindViewHolder(holder, position);
    }

    public void showLoadMore() {
        loadMoreAndNoMoreDataCallback.onShowLoadMore(mLoadMoreView);
    }

    public void showNoMoreData() {
        loadMoreAndNoMoreDataCallback.onShowNoMoreData(mLoadMoreView);
    }

    protected LinearRVLoadMoreWrapper setLoadMoreView(View loadMoreView, LoadMoreAndNoMoreDataCallback loadMoreAndNoMoreDataCallback) {
        this.loadMoreAndNoMoreDataCallback = loadMoreAndNoMoreDataCallback;
        return (LinearRVLoadMoreWrapper) setLoadMoreView(loadMoreView);
    }

    public LinearRVLoadMoreWrapper setLoadMoreView(int layoutId, LoadMoreAndNoMoreDataCallback loadMoreAndNoMoreDataCallback) {
        this.loadMoreAndNoMoreDataCallback = loadMoreAndNoMoreDataCallback;
        return (LinearRVLoadMoreWrapper) setLoadMoreView(layoutId);
    }

    protected void setDefaultLoadMoreView(Context context) {
        //TODO:可以在自己项目基类中覆盖此方法 添加项目公用的 加载更多layout
        //TODO：示例代码如下

        View loadMoreView = LayoutInflater.from(context).inflate(R.layout.loading_more, recyclerView, false);
        setLoadMoreView(loadMoreView, new LoadMoreAndNoMoreDataCallback() {

            @Override
            public void onShowLoadMore(View mLoadMoreView) {
                setLoadingState(mLoadMoreView, true);

            }

            @Override
            public void onShowNoMoreData(View mLoadMoreView) {
                setLoadingState(mLoadMoreView, false);
            }

        });
    }
    private void setLoadingState(View mLoadMoreView, boolean isNoMoreData) {
        View loading_more = mLoadMoreView.findViewById(R.id.loading_more);
        View no_more_data = mLoadMoreView.findViewById(R.id.no_more_data);
        loading_more.setVisibility(isNoMoreData ? View.VISIBLE : View.GONE);
        no_more_data.setVisibility(isNoMoreData ? View.GONE : View.VISIBLE);
    }

    public RecyclerView.Adapter getmInnerAdapter() {
        return mInnerAdapter;
    }



}
