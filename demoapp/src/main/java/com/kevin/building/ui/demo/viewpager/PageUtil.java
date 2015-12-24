package com.kevin.building.ui.demo.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.kevin.building.R;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {
    /**
     * 是否循环
     */
    public static final boolean isCycle = true;

    /**
     * 获取ViewPage适配器数据 ViewPage List
     *
     * @return
     */
    public static List<ViewPagerBean> getPageList(Context context) {
        List<ViewPagerBean> pageList = new ArrayList<ViewPagerBean>();
        for (int i = 0; i < 5; i++) {
            ViewPagerBean vpBean = new ViewPagerBean();
            vpBean.setTitle("Page" + (i + 1));
            vpBean.setLayoutResId(R.drawable.linear_login);
            vpBean.setView(getPageView(context, vpBean.getLayoutResId()));
            pageList.add(vpBean);
        }
        return pageList;
    }


    /**
     * 构造ViewPage页面
     *
     * @param context
     * @param imgResId
     * @return
     */
    private static View getPageView(Context context, int imgResId) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View pageView = inflater.inflate(R.layout.page_item, null);
        ImageView imgPage = (ImageView) pageView.findViewById(R.id.imgPage);
        imgPage.setImageResource(imgResId);
        return pageView;
    }


}
