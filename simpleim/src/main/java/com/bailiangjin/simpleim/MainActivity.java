package com.bailiangjin.simpleim;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.bailiangjin.simpleim.base.BaseActivity;

public class MainActivity extends BaseActivity {

    public static void start(Activity activity){
        Intent intent = new Intent(activity,MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initIntentData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


}
