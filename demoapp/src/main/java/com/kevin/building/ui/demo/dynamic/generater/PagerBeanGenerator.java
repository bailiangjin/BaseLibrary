package com.kevin.building.ui.demo.dynamic.generater;

import com.kevin.building.ui.demo.dynamic.bean.PageInfo;
import com.kevin.building.ui.demo.dynamic.bean.PageParamBean;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewBean;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/18 17:57
 */
public class PagerBeanGenerator {

    public static PageParamBean getViewBean(PageInfo pageInfo, List<ViewBean> viewBeanList) {
        PageParamBean pageParamBean = new PageParamBean();
        pageParamBean.setPageInfo(pageInfo);
        pageParamBean.setViewBeanList(viewBeanList);
        return pageParamBean;

    }
}
