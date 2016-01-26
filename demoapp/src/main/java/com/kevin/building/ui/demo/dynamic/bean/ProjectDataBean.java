package com.kevin.building.ui.demo.dynamic.bean;

import java.util.List;

/**
 * 项目整体json对应 实体类
 *
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/26 15:55
 */
public class ProjectDataBean {

    private String version;

    private List<ClassDataBean> classPackageBeanList;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ClassDataBean> getClassPackageBeanList() {
        return classPackageBeanList;
    }

    public void setClassPackageBeanList(List<ClassDataBean> classPackageBeanList) {
        this.classPackageBeanList = classPackageBeanList;
    }
}
