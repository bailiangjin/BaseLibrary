package com.kevin.building.demo.dynamic;

import android.os.Message;
import android.view.View;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 11:14
 */
public class DetailActivity extends BaseActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_dynamic;
    }

    @Override
    protected void initView() {
//        getIntent().getStringExtra("name");

        show("detail page:" + getIntent().getStringExtra("name"));

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void onViewClick(View v) {

    }

    @Override
    protected void handleMsg(Message msg) {

    }
}
