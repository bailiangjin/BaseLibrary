package com.kevin.building.ui.demo.fragmentdemo;

import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.kevin.building.base.BaseActivity;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/25 15:23
 */
public class FragmentAdapterDemos  extends BaseActivity{



    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initView() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

//        fragmentTransaction.replace(android.R.id.content, getFragment1());

        fragmentTransaction.commit();

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
