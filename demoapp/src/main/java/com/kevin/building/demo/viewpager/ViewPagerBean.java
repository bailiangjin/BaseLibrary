package com.kevin.building.demo.viewpager;

import android.view.View;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/24 14:09
 */
public class ViewPagerBean {
    /**
     * 标题
     */
    private String title;
    /**
     * 对应资源id
     */
    private int layoutResId;
    /**
     * view
     */
    private View view;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLayoutResId() {
        return layoutResId;
    }

    public void setLayoutResId(int layoutResId) {
        this.layoutResId = layoutResId;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
