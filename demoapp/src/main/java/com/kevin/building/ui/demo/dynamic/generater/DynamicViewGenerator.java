package com.kevin.building.ui.demo.dynamic.generater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.ui.demo.dynamic.callback.ClickCallback;
import com.kevin.building.ui.demo.dynamic.adapter.BtnSkipGroupAdapter;
import com.kevin.building.ui.demo.dynamic.view.BaseTextView;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewBean;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.constants.ItemType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.BtnItem;

import java.util.List;

/**
 * ViewBean 动态解析器 用于将ViewBean解析为相应的View 并返回
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 10:39
 */
public class DynamicViewGenerator {

    /**
     * 动态解析方法  动态解析ViewBean 返回View元素
     *
     * @param context  上下文 BaseActivity
     * @param viewBean ViewBean
     * @return View
     */
    public static View getView(BaseActivity context, ViewBean viewBean) {
        int itemType = viewBean.getItemType();
        switch (itemType) {
            case ItemType.TEXT:
                return getTitleTextView(context, viewBean.getTextItem().getIndex());
            case ItemType.BTN_GROUP:
                return getBtnGroup(context, viewBean);
            default:
                return null;
        }


    }


    private static BaseTextView getTitleTextView(Context context, String title) {

        return new BaseTextView(context, title);
    }


    private static GridView getGridView(Context context, final ClickCallback clickCallback) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        GridView gridView = (GridView) layoutInflater.inflate(R.layout.ctn_gridview, null);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickCallback.onClick(position);
            }
        });
        return gridView;
    }

    private static View getBtnGroup(BaseActivity baseActivity, ViewBean viewBean) {
        GridView gridView;
        List<BtnItem> btnItemList = viewBean.getBtnGroup().getBtnList();
        ClickCallback inesCallback = CallBackGenerator.getSkipCallback(baseActivity, btnItemList);
        gridView = getGridView(baseActivity, inesCallback);
        gridView.setAdapter(new BtnSkipGroupAdapter(baseActivity, btnItemList));
        return gridView;
    }
}
