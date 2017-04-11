package com.bailiangjin.demo.demo.dynamic.callback;

/**
 * 列表点击事件回调 ListView && GridVIew
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 11:17
 */
public interface MyOnClickListener {

    /**
     * 点击事件
     *
     * @param position 点击位置
     */
    public void onClick(final int position);
}
