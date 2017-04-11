package com.bailiangjin.demo.demo.dynamic.view.impl.textview;

import android.content.Context;
import android.view.Gravity;

import com.bailiangjin.demo.demo.dynamic.bean.viewbean.item.TextItem;
import com.bailiangjin.demo.demo.dynamic.view.base.BaseTextView;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 14:09
 */
public class ContentTextView extends BaseTextView {


    public ContentTextView(Context context, TextItem textItem) {
        super(context, textItem);
    }

    @Override
    protected int getGravity() {
        return Gravity.CENTER;
    }

    @Override
    protected int getTextSize() {
        return 14;
    }
}
