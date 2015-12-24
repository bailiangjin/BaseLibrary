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
     * 获取ViewPage List
     *
     * @return
     */
    public static List<VpBean> getPageList() {
        List<VpBean> pageList = new ArrayList<VpBean>();
        for (int i = 0; i < 5; i++) {
            VpBean vpBean = new VpBean();
            vpBean.setTitle("Pager" + (i+1));
            vpBean.setLayoutResId(R.drawable.icon_user);
            pageList.add(vpBean);
        }
        return pageList;
    }

    /**
     * 获取ViewPage适配器数据
     *
     * @param context
     * @return
     */
    public static List<VpBean> getPageList(Context context) {
        List<VpBean> vpList = getPageList();
        List<VpBean> pageList = new ArrayList<VpBean>();
        for (VpBean vpBean : vpList) {
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

//    private static View getPageView4Last(final Context context, int imgResId) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View pageView = inflater.inflate(R.layout.idendify_guide3, null);
//        Button startpage_btn = (Button) pageView.findViewById(R.id.startpage_btn);
//        pageView.setBackgroundResource(imgResId);
//        startpage_btn.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        return pageView;
//    }


}
