package com.bailiangjin.demo.demo.dynamic.view.impl.textview;

import android.content.Context;
import android.view.Gravity;

import com.bailiangjin.demo.demo.dynamic.bean.viewbean.item.TextItem;
import com.bailiangjin.demo.demo.dynamic.view.base.BaseTextView;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/19 15:19
 */
public class TitleTextView extends BaseTextView {

    public TitleTextView(Context context, TextItem textItem) {
        super(context, textItem);
    }

    @Override
    protected int getGravity() {
        return Gravity.CENTER;
    }

    @Override
    protected int getTextSize() {
        return 18;
    }
}
