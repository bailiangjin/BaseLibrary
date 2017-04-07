package com.bailiangjin.uilibrary.recyclerview.adapter;

import android.content.Context;

import com.bailiangjin.uilibrary.R;

/**
 * Created by bailiangjin on 2017/3/24.
 */

public class HSItemDecoration extends CommonItemDecoration {

    private static final int DEFAULT_COLOR = R.color.base_bg_color;
    private static final float DEFAULT_LINE_WIDTH = 0.5F;

    /**
     * 默认参数 无特殊要求 使用该构造参数即可
     * @param context
     */
    public HSItemDecoration(Context context) {
        super(context, DEFAULT_COLOR, 0.5f);
    }

    public HSItemDecoration(Context context, int colorResId) {
        super(context, colorResId, DEFAULT_LINE_WIDTH);
    }

    public HSItemDecoration(Context context, float lineWidth) {
        super(context, DEFAULT_COLOR, lineWidth);
    }

    public HSItemDecoration(Context context,int colorResId, float lineWidth) {
        super(context, colorResId, lineWidth);
    }
}
