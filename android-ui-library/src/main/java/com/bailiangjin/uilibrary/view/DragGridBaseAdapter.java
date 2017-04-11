package com.bailiangjin.uilibrary.view;

public interface DragGridBaseAdapter {
    /**
     * 重新排列数据
     *
     * @param oldPosition
     * @param newPosition
     */
    void reorderItems(int oldPosition, int newPosition);


    /**
     * 设置某个item隐藏
     *
     * @param hidePosition
     */
    void setHideItem(int hidePosition);


}
