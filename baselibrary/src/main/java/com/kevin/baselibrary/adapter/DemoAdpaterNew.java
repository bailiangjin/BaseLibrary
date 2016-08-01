package com.kevin.baselibrary.adapter;

import android.app.Activity;
import android.view.View;

import com.kevin.baselibrary.base.SuperBaseAdapterNew;

import java.util.List;

/**
 * Created by bailiangjin on 16/8/1.
 */
public class DemoAdpaterNew extends SuperBaseAdapterNew<String> {

    public DemoAdpaterNew(Activity activity, List<String> dataList) {
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


    public class DemoViewHolder extends ViewHolder<String> {

        public DemoViewHolder(View rootView) {
            super(rootView);
        }

        @Override
        public void show(String data) {

        }
    }
}
