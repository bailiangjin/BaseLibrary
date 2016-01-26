package com.kevin.building.ui.demo.dynamic.bean;

import java.util.List;

/**
 * 拍摄大类 Json数据 实体类
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/26 15:54
 */
public class ClassDataBean {

    /**
     * 采集大类名称
     */
    private  String name;
    /**
     * 该采集类包含的小类采集页面 List
     */
    private List<PageParamBean> pageParamBeanList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PageParamBean> getPageParamBeanList() {
        return pageParamBeanList;
    }

    public void setPageParamBeanList(List<PageParamBean> pageParamBeanList) {
        this.pageParamBeanList = pageParamBeanList;
    }
}
