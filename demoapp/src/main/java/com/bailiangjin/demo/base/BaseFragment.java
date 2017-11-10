package com.bailiangjin.demo.base;

import android.view.View;

import com.bailiangjin.uilibrary.fragment.SuperBaseFragment;


/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/12 11:39
 */
public abstract class BaseFragment extends SuperBaseFragment {

    @Override
    public String getScreenId() {
        return null;
    }

    @Override
    public void onScreenResume(String screenId) {

    }

    @Override
    protected void beforeViewBind() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindView(View view) {

    }

    @Override
    protected void unBindView() {

    }


}

