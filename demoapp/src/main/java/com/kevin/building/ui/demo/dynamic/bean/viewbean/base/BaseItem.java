package com.kevin.building.ui.demo.dynamic.bean.viewbean.base;

import android.view.Gravity;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 15:54
 */
public abstract class BaseItem {

    /**
     * 类型
     */
    private int viewType;
    /**
     * ID
     */
    private String id;

    /**
     * name 数据库使用字段
     */
    private String name;

    /**
     * 文字 Button的文字/Text的文字内容/输入框前的导引文字/CheckBox 对应的说明文字/RadioButton对应的说明文字
     */
    private String indexText;

    /**
     * index 文字大小 dp
     */
    private transient int indexTextSize;

    /**
     * 是否必须
     */
    private boolean isMust;

    /**
     * 是否为只读状态 只读状态不可编辑
     */
    private boolean isRead;


    /**
     * 对齐方式 居中17=Gravity.CENTER 靠左3=Gravity.LEFT 靠右5=Gravity.RIGHT
     *
     * 添加transient标识的字段不会转化到json结构 对于json可忽略
     */
    private transient int gravity;


    /**
     * 扩展字段
     */
    private ExtraParam extraParam;

    public BaseItem() {
        setDefaultViewType();
        setDefaultData();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getIndexText() {
        return indexText;
    }

    public void setIndexText(String indexText) {
        this.indexText = indexText;
    }

    public boolean isMust() {
        return isMust;
    }

    public void setIsMust(boolean isMust) {
        this.isMust = isMust;
    }


    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getIndexTextSize() {
        return indexTextSize;
    }

    public void setIndexTextSize(int indexTextSize) {
        this.indexTextSize = indexTextSize;
    }


    public ExtraParam getExtraParam() {
        return extraParam;
    }

    public void setExtraParam(ExtraParam extraParam) {
        this.extraParam = extraParam;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public void setDefaultData() {
        setId(String.valueOf(System.currentTimeMillis()));
        setGravity(Gravity.CENTER);
        setIndexText("默认文本");
        setIndexTextSize(14);
        setIsMust(true);
//        setIndexTextColor(888);
        ExtraParam extraParam = new ExtraParam();
        extraParam.setExtra1("扩展参数1");
        setExtraParam(extraParam);
        setIsRead(false);

    }

    abstract public void setDefaultViewType();
}
