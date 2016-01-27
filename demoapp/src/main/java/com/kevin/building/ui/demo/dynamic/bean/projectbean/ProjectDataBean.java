package com.kevin.building.ui.demo.dynamic.bean.projectbean;

import java.util.List;

/**
 * 项目整体json对应 实体类
 *
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/26 15:55
 */
public class ProjectDataBean {

    /**
     * 项目id
     */
    private String id;

    /**
     * 版本号
     */
    private String versionNo;

    /**
     *  拍摄大类 List
     */
    private List<ClassDataBean> classPackageBeanList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public List<ClassDataBean> getClassPackageBeanList() {
        return classPackageBeanList;
    }

    public void setClassPackageBeanList(List<ClassDataBean> classPackageBeanList) {
        this.classPackageBeanList = classPackageBeanList;
    }
}
