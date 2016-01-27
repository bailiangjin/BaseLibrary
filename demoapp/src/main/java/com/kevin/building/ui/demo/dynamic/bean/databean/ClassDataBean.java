package com.kevin.building.ui.demo.dynamic.bean.databean;

import java.util.List;

/**
 * 采集大类 Json数据 实体类
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/26 15:54
 */
public class ClassDataBean {

    /**
     * 采集品类id
     */
    private  String id;

    /**
     * 采集大类名称
     */
    private  String name;
    /**
     * 该采集类包含的小类采集页面 List
     */
    private List<PageDataBean> pageDataBeanList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PageDataBean> getPageDataBeanList() {
        return pageDataBeanList;
    }

    public void setPageDataBeanList(List<PageDataBean> pageDataBeanList) {
        this.pageDataBeanList = pageDataBeanList;
    }
}
