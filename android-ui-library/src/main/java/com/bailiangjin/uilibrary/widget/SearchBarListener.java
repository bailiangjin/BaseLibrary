package com.bailiangjin.uilibrary.widget;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/26 13:48
 */
public interface SearchBarListener {
    /**
     * 搜索事件
     * @param searchKey
     * @return
     */
    boolean onSearch(String searchKey);

    /**
     * 输入框文字变化
     * @param curTextStr
     */
    boolean onTextChange(String curTextStr);

    /**
     * 点击取消回调
     */
    boolean onCancelClick();
}
