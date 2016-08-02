package com.kevin.baselibrary.adapter;

import android.app.Activity;
import android.view.View;

import com.kevin.baselibrary.base.SuperBaseAdapterNew;
import com.kevin.baselibrary.model.GroupModel;

import java.util.List;

/**
 * Created by bailiangjin on 16/8/2.
 */
public class DemoAdapterNew2 extends SuperBaseAdapterNew<GroupModel> {
    public DemoAdapterNew2(Activity activity, List<GroupModel> dataList) {
        super(activity, dataList);
    }

    @Override
    public int getItemLayoutResId() {
        return 0;
    }

    @Override
    protected ViewHolder getViewHolder(View rootView) {
        return new DemoViewHolder(rootView);
    }


    public class DemoViewHolder extends ViewHolder<GroupModel> {

        public DemoViewHolder(View rootView) {
            super(rootView);
        }

        @Override
        public void show(int position, GroupModel data) {

        }
    }


}
