package com.kevin.architecture;

import android.os.Bundle;

import com.kevin.architecture.activity.BaseActivity;
import com.kevin.baselibrary.utils.LogUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/22 16:15
 */
public class MainActivity extends BaseActivity{


    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_new);
        LogUtils.e("设置了Root");
    }

    @Override
    protected void loadDData() {

    }
}
