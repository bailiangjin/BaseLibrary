package com.bailiangjin.simpleim.appcommon.base;

import android.view.View;

import com.bailiangjin.uilibrary.fragment.SuperBaseFragment;

import butterknife.ButterKnife;

/**
 * Created by bailiangjin on 16/9/30.
 */

public abstract class BaseFragment extends SuperBaseFragment {

    @Override
    protected void bindView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    protected void unBindView() {

    }

    @Override
    protected void initListener() {

    }
}
