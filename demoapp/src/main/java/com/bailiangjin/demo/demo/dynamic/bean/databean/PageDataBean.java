package com.bailiangjin.demo.demo.dynamic.bean.databean;

import com.bailiangjin.demo.demo.dynamic.bean.viewbean.ViewBean;

import java.util.List;

/**
 * 页面完整参数Bean 该类对应一个完整的动态页面
 * <p/>
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/28 14:23
 */
public class PageDataBean {

    /**
     * 页面基本参数
     */
    private PageInfo pageInfo;

    /**
     * 界面元素列表
     */
    private List<ViewBean> viewBeanList;

    public PageDataBean() {

    }

    public PageDataBean(PageInfo pageInfo, List<ViewBean> viewBeanList) {
        this.pageInfo = pageInfo;
        this.viewBeanList = viewBeanList;
    }



    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<ViewBean> getViewBeanList() {
        return viewBeanList;
    }

    public void setViewBeanList(List<ViewBean> viewBeanList) {
        this.viewBeanList = viewBeanList;
    }
}
