package com.kevin.baselibrary.utils.android;

import android.content.Context;
import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.baselibrary.R;

/**
 * 通用ViewUtils
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/22 15:58
 */
public class SuperViewUtils {

    /**
     * 设置TextView 下划线效果
     *
     * @param tv
     */
    public static void setUnderline(TextView tv) {

        tv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

    }

    /**
     * 获取dot imageView 数组
     *
     * @param dotNum
     * @return
     */
    public static ImageView[] getDotImageViews(Context context, int dotNum) {
        ImageView[] ivDots = new ImageView[dotNum];
        for (int i = 0; i < dotNum; i++) {
            ImageView iv_dot = getDotImageView(context, 8);
            if (0 == i) {
                iv_dot.setSelected(true);
            }
            ivDots[i] = iv_dot;
        }
        return ivDots;
    }

    /**
     * 获取 dot imageView
     *
     * @param context    context
     * @param dotSize    点直径大小 dp
     * @return
     */
    public static ImageView getDotImageView(Context context, int dotSize) {
        ImageView iv_dot = new ImageView(context);
        iv_dot.setBackgroundResource(R.drawable.base_dot_selector);
        // 设置圆点布局参数
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                DensityUtils.dip2px(dotSize),
                DensityUtils.dip2px(dotSize));
        params.setMargins(7, 0, 7, 0);
        iv_dot.setLayoutParams(params);
        return iv_dot;
    }


    /**
     * 添加点到 LinearLayout
     *
     * @param ll_dot LinearLayout
     * @param ivDots imageView数组
     */
    public static void addDot2Layout(LinearLayout ll_dot, ImageView[] ivDots) {
        for (ImageView iv : ivDots) {
            ll_dot.addView(iv);
        }
    }
}
