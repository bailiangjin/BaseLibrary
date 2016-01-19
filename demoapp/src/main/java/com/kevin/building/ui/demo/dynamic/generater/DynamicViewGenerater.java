package com.kevin.building.ui.demo.dynamic.generater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.ui.demo.dynamic.ClickCallback;
import com.kevin.building.ui.demo.dynamic.adapter.BtnGroupAdapter;
import com.kevin.building.ui.demo.dynamic.bean.ViewItem;
import com.kevin.building.ui.demo.dynamic.view.BaseTextView;
import com.kevin.building.ui.demo.dynamic.viewbean.ViewBean;
import com.kevin.building.ui.demo.dynamic.viewbean.constants.ItemType;
import com.kevin.building.ui.demo.dynamic.viewbean.item.BtnItem;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 10:39
 */
public class DynamicViewGenerater {

    public static View getView(BaseActivity context, ViewBean viewBean) {
        int itemType = viewBean.getItemType();
        switch (itemType) {
            case ItemType.TEXT:
                return getTitleTextView(context, viewBean.getTextItem().getIndex());
            case  ItemType.BTN_GROUP:
                return getBtnGroup(context,viewBean);
            default:
                return null;
        }


    }

    public static View getView(Context context, ViewItem baseItem) {
        int itemType = baseItem.getItemType();
        switch (itemType) {
            case ItemType.TEXT:
                return getTitleTextView(context, baseItem.getBaseTextView().getTextContent());
            case  ItemType.BTN_GROUP:
                return new BaseTextView(context, baseItem.getBaseTextView().getTextContent());
            default:
                return null;
        }


    }

    public static BaseTextView getTitleTextView(Context context, String title) {

//        LayoutInflater layoutInflater = LayoutInflater.from(context);
//        // 创建TextView对象
//        TextView mTextView = (TextView) layoutInflater.inflate(R.layout.ctn_textview, null);
//        // 设置文字
//        mTextView.setText(title);
//        mTextView.setGravity(Gravity.CENTER_HORIZONTAL);
//        return mTextView;

        return new BaseTextView(context, title);
    }


    public static GridView getGridView(Context context, final ClickCallback clickCallback) {
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

    public static View getBtnGroup(BaseActivity baseActivity,ViewBean viewBean) {
        GridView gridView;
        List<BtnItem> btnItemList = viewBean.getBtnGroup().getBtnList();
        ClickCallback inesCallback = CallBackGenerater.getClickCallback(baseActivity, btnItemList);
        gridView = DynamicViewGenerater.getGridView(baseActivity, inesCallback);
        gridView.setAdapter(new BtnGroupAdapter(baseActivity, btnItemList));
        return gridView;
    }
}
