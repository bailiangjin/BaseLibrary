package com.kevin.building.demo.dynamic.generater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.kevin.building.R;
import com.kevin.building.demo.dynamic.callback.ClickCallback;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/28 15:10
 */
public class ViewToolNonLogic {


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
