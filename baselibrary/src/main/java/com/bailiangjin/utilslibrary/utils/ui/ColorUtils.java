package com.bailiangjin.utilslibrary.utils.ui;

import android.graphics.Color;

/**
 * Created by bailiangjin on 16/5/16.
 */
public class ColorUtils {

    private static final float DARKEN_SATURATION = 1.1f;
    private static final float DARKEN_INTENSITY = 0.9f;

    /**
     * 加深颜色 适用于获取某个颜色对应的按压色值 减少UI人员介入
     * @param color
     * @return
     */
    public static int darkenColor(int color) {
        float[] hsv = new float[3];
        int alpha = Color.alpha(color);
        Color.colorToHSV(color, hsv);
        hsv[1] = Math.min(hsv[1] * DARKEN_SATURATION, 1.0f);
        hsv[2] = hsv[2] * DARKEN_INTENSITY;
        int tempColor = Color.HSVToColor(hsv);
        return Color.argb(alpha, Color.red(tempColor), Color.green(tempColor), Color.blue(tempColor));
    }
}
