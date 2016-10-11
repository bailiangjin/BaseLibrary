package com.bailiangjin.simpleim.module.common.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by bailiangjin on 2016-09-30
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;


    public MainFragmentAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.fragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return null == fragmentList ? null : fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return null == fragmentList ? 0 : fragmentList.size();
    }

}


