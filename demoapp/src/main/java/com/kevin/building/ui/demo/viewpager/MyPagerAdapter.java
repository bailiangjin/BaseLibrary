package com.kevin.building.ui.demo.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/24 10:38
 */
public class MyPagerAdapter extends PagerAdapter {

    private List<VpBean> pageList;
    private int pageCount;

    public MyPagerAdapter(List<VpBean> pageList) {
        this.pageList = pageList;
        pageCount=pageList.size();
    }

    @Override
    public int getCount() {
        return null == pageList ? -1 : pageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (PageUtil.isCycle) {
            position = position % pageCount;
        }
        container.removeView(pageList.get(position).getView());
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (PageUtil.isCycle) {
            position = position % pageCount;
        }
        container.addView(pageList.get(position).getView());
        return pageList.get(position).getView();
    }

}
