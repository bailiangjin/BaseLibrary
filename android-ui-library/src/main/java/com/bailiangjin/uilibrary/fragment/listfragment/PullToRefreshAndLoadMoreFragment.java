package com.bailiangjin.uilibrary.fragment.listfragment;

import android.support.v4.widget.SwipeRefreshLayout;

import com.bailiangjin.uilibrary.R;
import com.bailiangjin.uilibrary.recyclerview.adapter.RVMultiTypeBaseAdapter;
import com.bailiangjin.uilibrary.recyclerview.wrapper.LinearRVLoadMoreWrapper;
import com.bailiangjin.uilibrary.rx.CommonSubscribe;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import rx.Subscriber;


/**
 * Created by bailiangjin on 2017/3/22.
 */

public abstract class PullToRefreshAndLoadMoreFragment extends ListFragment {

    SwipeRefreshLayout swipeRefreshLayout;


    LinearRVLoadMoreWrapper loadMoreWrapper;

    private static final int DEFAULT_PAGE = 1;

    private int curPage = DEFAULT_PAGE;
    private boolean hasMoreData = true;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_with_refresh_load_more_rv_list;
    }


    @Override
    protected void beforeViewBind() {

    }

    @Override
    protected void initView() {
        swipeRefreshLayout= (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
        super.initView();
    }

    @Override
    protected void initRefresh() {
        super.initRefresh();
        swipeRefreshLayout.setColorSchemeResources(R.color.color_scheme_2_1,
                R.color.color_scheme_2_2, R.color.color_scheme_2_3,
                R.color.color_scheme_2_4);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                curPage = DEFAULT_PAGE;
                //下拉刷新
                initOrRefreshData(new CommonSubscribe<Boolean>() {
                    @Override
                    public void onNext(Boolean isSuccess) {
                        hideRefreshProgressBar();
                        if(isSuccess){
                            loadMoreWrapper.notifyDataSetChanged();
                        }

                    }
                });

            }
        });
    }



    @Override
    protected void initLoadMore() {
        super.initLoadMore();
        loadMoreWrapper = new LinearRVLoadMoreWrapper(listRvAdapter, recyclerView);
        loadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                if(hasMoreData){
                    //加载更多
                    loadMoreData(new CommonSubscribe<Boolean>() {

                        @Override
                        public void onNext(Boolean isSuccess) {
                            if (isSuccess) {
                                loadMoreWrapper.notifyDataSetChanged();
                            } else {
                                hasMoreData=false;
                                loadMoreWrapper.showNoMoreData();
                            }
                        }
                    });
                }

            }
        });
        realAdapter=loadMoreWrapper;
    }

    @Override
    protected void setAdapter(RVMultiTypeBaseAdapter adapter) {
        super.setAdapter(adapter);
        initLoadMore();
    }

    protected void hideRefreshProgressBar() {
        swipeRefreshLayout.setRefreshing(false);
    }

    protected void disableRefresh() {
        swipeRefreshLayout.setEnabled(false);
    }

    protected void enableRefresh() {
        swipeRefreshLayout.setEnabled(true);
    }


    public abstract void initOrRefreshData(Subscriber<Boolean> subscriber);

    protected abstract void loadMoreData(Subscriber<Boolean> subscriber);





}
