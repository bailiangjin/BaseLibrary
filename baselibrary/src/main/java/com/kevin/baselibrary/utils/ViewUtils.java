package com.kevin.baselibrary.utils;

import android.graphics.Paint;
import android.widget.TextView;

/**
 * 通用ViewUtils
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/22 15:58
 */
public class ViewUtils {

    /**
     * 设置TextView 下划线效果
     * @param tv
     */
    public static void setUnderline(TextView tv) {

        tv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG| Paint.ANTI_ALIAS_FLAG);

    }
}
