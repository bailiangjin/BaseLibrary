package com.kevin.building.ui.demo.dynamic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.kevin.building.R;
import com.kevin.building.ui.demo.dynamic.bean.ViewItem;
import com.kevin.building.ui.demo.dynamic.enumtype.ItemType;
import com.kevin.building.ui.demo.dynamic.view.BaseTextView;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 10:39
 */
public class DynamicViewGenerater {

    public static View getView(Context context, ViewItem baseItem) {
        ItemType itemType = baseItem.getItemType();
        switch (itemType) {
            case TEXTVIEW:
                return getTitleTextView(context, baseItem.getBaseTextView().getTextContent());
            case GRIDVIEW:
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
}
