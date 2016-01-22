package com.kevin.building.ui.demo.dynamic.generater;

import com.kevin.building.ui.demo.dynamic.bean.PageInfo;
import com.kevin.building.ui.demo.dynamic.bean.PageParamBean;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewItem;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/18 17:57
 */
public class PagerBeanGenerator {

    public static PageParamBean getViewBean(PageInfo pageInfo, List<ViewItem> viewBeanList) {
        PageParamBean pageParamBean = new PageParamBean();
        pageParamBean.setPageInfo(pageInfo);
        pageParamBean.setViewItemList(viewBeanList);
        return pageParamBean;

    }
}
