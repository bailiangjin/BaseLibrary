package com.kevin.building.ui.demo.dynamic.viewbean.base;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 15:54
 */
public abstract class BaseItem {

    private int viewType;
    private String id;
    private String index;
    private String paramJson;

    public BaseItem(){
        setDefaultViewType();
        setDefaultData();
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

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getParamJson() {
        return paramJson;
    }

    public void setParamJson(String paramJson) {
        this.paramJson = paramJson;
    }

    public void setDefaultData() {
//        setId(String.valueOf(System.currentTimeMillis()));
//        setIndex("view说明");
        setParamJson("Json参数");

    }

    abstract public void setDefaultViewType();
}
