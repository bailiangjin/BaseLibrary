package com.kevin.building.demo.recycleview;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.databinding.ActivityRecycleviewBinding;

/**
 * Created by bailiangjin on 16/7/4.
 */
public class RecyclerViewDemoActivity extends BaseActivity<ActivityRecycleviewBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_recycleview;
    }

    @Override
    protected void initIntentData(Bundle savedInstanceState) {

    }


    @Override
    protected void initView(Bundle savedInstanceState) {
//        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));//这里用线性宫格显示 类似于grid view
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流
        getBinding().recyclerView.setAdapter(new NormalRecyclerViewAdapter(this));

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }




    @Override
    protected void handleMsg(Message msg) {

    }
}
