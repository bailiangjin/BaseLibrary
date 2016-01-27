package com.kevin.building.ui.demo.dynamic.generater;

import com.kevin.building.ui.demo.dynamic.bean.databean.PageInfo;
import com.kevin.building.ui.demo.dynamic.bean.databean.PageDataBean;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewBean;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/18 17:57
 */
public class PagerBeanGenerator {

    public static PageDataBean getViewBean(PageInfo pageInfo, List<ViewBean> viewBeanList) {
        PageDataBean pageParamBean = new PageDataBean();
        pageParamBean.setPageInfo(pageInfo);
        pageParamBean.setViewBeanList(viewBeanList);
        return pageParamBean;

    }
}
