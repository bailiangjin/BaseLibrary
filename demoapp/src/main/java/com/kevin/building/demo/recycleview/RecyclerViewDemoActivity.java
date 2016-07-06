package com.kevin.building.demo.recycleview;

import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kevin.baselibrary.base.SuperBaseActivity;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

/**
 * Created by bailiangjin on 16/7/4.
 */
public class RecyclerViewDemoActivity extends BaseActivity {

    RecyclerView recyclerView;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_recycleview;
    }



    @Override
    protected void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));//这里用线性宫格显示 类似于grid view
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流
        recyclerView.setAdapter(new NormalRecyclerViewAdapter(this));

    }

    @Override
    protected void initData() {

    }


    @Override
    protected void onViewClick(View v) {

    }

    @Override
    protected void handleMsg(Message msg) {

    }
}
