package com.bailiangjin.uilibrary.activity;

/**
 * Created by bailiangjin on 16/9/8.
 */
public interface BaseActivityInterface {

    /**
     * show toast by string
     *
     * @param string
     */
    void shortToast(String string);

    /**
     * show toast by res id
     *
     * @param resId
     */
    void shortToast(int resId);

    /**
     * long toast
     *
     * @param string
     */
    void longToast(String string);

    /**
     * long toast
     *
     * @param resId
     */
    void longToast(int resId);


    /**
     * 隐藏公共title
     */
    void hideCommonBaseTitle();

    /**
     * 显示公共的title
     */
    void showCommonBaseTitle();


    /**
     * 显示正在加载数据进度dialog
     */
    void showLoadDataDialog();

    /**
     * 显示进度dialog
     *
     * @param content 提示文字内容
     */
    void showProgressDialog(String content);

    /**
     * 隐藏进度dialog
     */
    void hideProgressDialog();

    void setStatusBar();

    void bindView();

    void unbindView();
}
