package com.kevin.building.ui.demo.dynamic.view.textview;

import android.content.Context;
import android.view.Gravity;

import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.TextItem;
import com.kevin.building.ui.demo.dynamic.view.base.AbsBaseTextView;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/19 15:19
 */
public class ClassNameTextView extends AbsBaseTextView {


    public ClassNameTextView(Context context, TextItem textItem) {
        super(context, textItem);
    }

    @Override
    protected int getGravity() {
        return Gravity.LEFT;
    }

    @Override
    protected int getTextSize() {
        return 16;
    }
}
