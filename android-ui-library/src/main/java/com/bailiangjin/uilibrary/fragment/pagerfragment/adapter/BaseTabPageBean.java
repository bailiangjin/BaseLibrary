package com.bailiangjin.uilibrary.fragment.pagerfragment.adapter;

/**
 * ViewPagerFragment对应数据的基类
 * Created by bailiangjin on 2017/3/22.
 */

public class BaseTabPageBean<T extends Object> {

    /**
     * tab标题
     */
    private String title;

    private T data;

    public BaseTabPageBean(String title, T data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
