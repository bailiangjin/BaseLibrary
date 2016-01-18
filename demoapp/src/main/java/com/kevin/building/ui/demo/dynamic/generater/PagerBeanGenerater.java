package com.kevin.building.ui.demo.dynamic.generater;

import com.kevin.building.ui.demo.dynamic.PageParamBean;
import com.kevin.building.ui.demo.dynamic.viewbean.ViewBean;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/18 17:57
 */
public class PagerBeanGenerater {

    public static PageParamBean getViewBean(List<ViewBean> viewBeanList) {
        PageParamBean pageParamBean = new PageParamBean();
        pageParamBean.setViewBeanList(viewBeanList);
        return pageParamBean;

    }
}
