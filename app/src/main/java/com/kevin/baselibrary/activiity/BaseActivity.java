package com.kevin.baselibrary.activiity;

import android.support.v4.app.FragmentActivity;

import com.kevin.baselibrary.utils.ToastUtils;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/9/28 23:10
 */
public class BaseActivity extends FragmentActivity {


    /**
     * show toast by string
     *
     * @param string
     */
    protected void show(String string) {
        ToastUtils.shortShow(BaseActivity.this, string);
    }

    /**
     * show toast by res id
     *
     * @param resId
     */
    protected void show(int resId) {
        ToastUtils.shortShow(BaseActivity.this, resId);
    }

    /**
     * long toast
     *
     * @param string
     */
    protected void longShow(String string) {
        ToastUtils.longShow(BaseActivity.this, string);
    }

    /**
     * long toast
     *
     * @param resId
     */
    protected void longShow(int resId) {
        ToastUtils.longShow(BaseActivity.this, resId);
    }


}




