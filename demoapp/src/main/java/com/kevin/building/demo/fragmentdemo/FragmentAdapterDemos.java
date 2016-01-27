package com.kevin.building.demo.fragmentdemo;

import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/25 15:23
 */
public class FragmentAdapterDemos  extends BaseActivity{

    private ViewPager vp_images;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_viewpager_demo;
    }

    @Override
    protected void initView() {
        vp_images = (ViewPager) findViewById(R.id.vp_images);
        FragmentManager fm = getSupportFragmentManager();
        vp_images.setAdapter(new MyFragmentPagerAdapter(fm));


//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//
////        fragmentTransaction.replace(android.R.id.content, getFragment1());
//
//        fragmentTransaction.commit();

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
