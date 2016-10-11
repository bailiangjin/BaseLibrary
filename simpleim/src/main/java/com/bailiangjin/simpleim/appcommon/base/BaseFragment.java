package com.bailiangjin.simpleim.appcommon.base;

import android.view.View;

import com.kevin.baselibrary.base.SuperBaseFragment;

import butterknife.ButterKnife;

/**
 * Created by bailiangjin on 16/9/30.
 */

public abstract class BaseFragment extends SuperBaseFragment{

    @Override
    protected void bindView(View view) {
        ButterKnife.bind(this, view);
    }
}
