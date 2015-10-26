package com.kevin.building.view;

import android.content.Context;
import android.util.AttributeSet;

import com.kevin.baselibrary.utils.ToastUtils;
import com.kevin.baselibrary.view.SearchBar;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/26 11:38
 */
public class MySearchBar extends SearchBar{


    public MySearchBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onSearch(String searchKey) {
        ToastUtils.show("搜索");
        return false;
    }

    @Override
    public void onEditTextChange(String searchKey) {
        ToastUtils.show("内容变化");

    }

    @Override
    public void onCancelClicked() {
        ToastUtils.show("点击了取消");
    }
}
