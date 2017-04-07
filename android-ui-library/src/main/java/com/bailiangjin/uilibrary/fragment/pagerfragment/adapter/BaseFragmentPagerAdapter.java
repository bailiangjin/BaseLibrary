package com.bailiangjin.uilibrary.fragment.pagerfragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bailiangjin on 2017/3/22.
 */

public abstract class BaseFragmentPagerAdapter<T extends BaseTabPageBean> extends FragmentPagerAdapter {

    private List<T> tabList=new ArrayList<>();

    /**
     * 构造方法
     * @param fm vip 注意 在fragment中使用请传入 getChildFragmentManager
     * @param tabList
     */
    public BaseFragmentPagerAdapter(FragmentManager fm, List<T> tabList) {
        super(fm);
        if (null!=tabList&&!tabList.isEmpty()){
            this.tabList.addAll(tabList);
        }
    }

    public BaseFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public List<T> getTabList() {
        return this.tabList;
    }

    public void setTabList(List<T> tabList) {
        if (null!=tabList&&!tabList.isEmpty()){
            this.tabList.addAll(tabList);
        }
    }

    @Override
    public int getCount() {
        return null == tabList ? 0 : tabList.size();
    }

    @Override
    public Fragment getItem(final int position) {

       return getItemFragment(position,getDataItem(position));
    }

    public T getDataItem(final int position) {

        return null == tabList || position > tabList.size() - 1 ? null : tabList.get(position);
    }


    @Override
    public CharSequence getPageTitle(final int position) {
        return null == tabList || position > tabList.size() - 1 ? null : tabList.get(position).getTitle();

    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    protected abstract Fragment getItemFragment(int position, T tabData);
}
