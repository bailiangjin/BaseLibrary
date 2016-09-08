package com.kevin.building.demo.dynamic;

import android.os.Message;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity2;
import com.kevin.building.databinding.ActivityDynamicBinding;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 11:14
 */
public class DetailActivity extends BaseActivity2<ActivityDynamicBinding> {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_dynamic;
    }

    @Override
    protected void initIntentData() {

    }

    @Override
    protected void initView() {
//        getIntent().getStringExtra("name");

        shortToast("detail page:" + getIntent().getStringExtra("name"));

    }

    @Override
    protected void initData() {

    }



    @Override
    protected void handleMsg(Message msg) {

    }
}
