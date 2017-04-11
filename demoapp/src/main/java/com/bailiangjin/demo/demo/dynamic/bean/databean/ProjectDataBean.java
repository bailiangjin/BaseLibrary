package com.bailiangjin.demo.demo.dynamic.bean.databean;

import java.util.List;

/**
 * 采集项目Bean
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
    private List<ClassDataBean> classDataBeanList;

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

    public List<ClassDataBean> getClassDataBeanList() {
        return classDataBeanList;
    }

    public void setClassDataBeanList(List<ClassDataBean> classDataBeanList) {
        this.classDataBeanList = classDataBeanList;
    }
}
