package com.kevin.baselibrary.utils.android;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;


public class LayoutUtils {

    /**
     * 设计屏幕宽高比
     */
    private final float designRatio = 0.5625f;
    /**
     * 实际屏幕显示区域宽高比
     */
    private float deviceWHRatio;
    /**
     * 实际屏幕显示区域 宽度
     */
    private static float screenWidth;
    /**
     * 实际屏幕显示区域 高度
     */
    private static float screenHeight;


    /**
     * 构造函数
     *
     * @param activity
     */
    public LayoutUtils(Activity activity) {

        screenWidth = ScreenUtils.getScreenWidth(activity);// 宽度
        screenHeight = ScreenUtils.getScreenheight(activity);// 高度

        //实际设备显示区域宽高比
        deviceWHRatio = screenWidth / screenHeight;
    }

    /**
     * 通用设置View参数
     */
    public void setViewParams(ViewGroup view, float width, float height, float marginLeft, float marginRight,
                              float marginTop, float marginBottom) {

        LayoutParams params = (LayoutParams) view.getLayoutParams();
        setViewGroupLayoutParams(view, params, width, height, marginLeft, marginRight, marginTop, marginBottom);
    }

    /**
     * 按设计宽高比 设置控件参数
     */
    public void setViewParamsByRatio(ViewGroup view, float width, float height, float marginLeft, float marginRight,
                                     float marginTop, float marginBottom) {
        LayoutParams params = (LayoutParams) view.getLayoutParams();
        setViewGroupLayoutParams(view, params, width, height, marginLeft, marginRight, marginTop, marginBottom, true);
    }


    public void setLinearLayoutParams(LinearLayout view, float width, float height, float marginLeft, float marginRight,
                                      float marginTop, float marginBottom) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        setViewGroupLayoutParams(view, params, width, height, marginLeft, marginRight, marginTop, marginBottom);
    }

    public void setRelativeLayoutParams(RelativeLayout view, float width, float height, float marginLeft, float marginRight,
                                        float marginTop, float marginBottom) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        setViewGroupLayoutParams(view, params, width, height, marginLeft, marginRight, marginTop, marginBottom);
    }

    public void setViewGroupLayoutParams(ViewGroup view, float width, float height, float marginLeft, float marginRight,
                                         float marginTop, float marginBottom) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        setViewGroupLayoutParams(view, params, width, height, marginLeft, marginRight, marginTop, marginBottom);
    }


    public void setFrameLayoutParams(FrameLayout view, float width, float height, float marginLeft, float marginRight,
                                     float marginTop, float marginBottom) {

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        setViewGroupLayoutParams(view, params, width, height, marginLeft, marginRight, marginTop, marginBottom);
    }


    private void setViewGroupLayoutParams(ViewGroup view, ViewGroup.MarginLayoutParams params, float width, float height, float marginLeft, float marginRight,
                                          float marginTop, float marginBottom) {
        setViewGroupLayoutParams(view, params, width, height, marginLeft, marginRight, marginTop, marginBottom, false);
    }


    /**
     * 设置 ViewGroup 控件参数
     * 所有float 参数设置为 0.0f 时 不改变原尺寸
     *
     * @param view         ViewGroup 子类
     * @param params       ViewGroup.MarginLayoutParams
     * @param width        高度
     * @param height       宽度
     * @param marginLeft   距离左侧控件距离
     * @param marginRight  距离右侧控件距离
     * @param marginTop    距离顶部控件距离
     * @param marginBottom 距离底部控件距离
     * @param byRatio      是否按设计宽高比矫正
     */
    private void setViewGroupLayoutParams(ViewGroup view, ViewGroup.MarginLayoutParams params, float width, float height, float marginLeft, float marginRight,
                                          float marginTop, float marginBottom, boolean byRatio) {


        //按设计图比例赋值
        if (byRatio) {
            //动态矫正参数 计算屏幕实际显示区域宽高比 与 设计图宽高比的比率
            float ratio = deviceWHRatio / designRatio;
            if (ratio > 1) {//实际屏幕比较宽

                if (width > 0.0f) {
                    //压缩宽度
                    params.width = (int) (screenWidth * width / ratio);
                }

                if (height > 0.0f) {
                    params.height = (int) (screenHeight * height);
                }

            } else {//实际屏幕比较高

                if (width > 0.0f) {

                    params.width = (int) (screenWidth * width);
                }

                if (height > 0.0f) {
                    //压缩高度
                    params.height = (int) (screenHeight * height * ratio);
                }

            }

            //不进行矫正
        } else {

            if (width > 0.0f) {
                params.width = (int) (screenWidth * width);
            }

            if (height > 0.0f) {
                params.height = (int) (screenHeight * height);
            }

        }


        if (marginLeft > 0.0f) {
            params.leftMargin = (int) (screenWidth * marginLeft);
        }

        if (marginRight > 0.0f) {
            params.rightMargin = (int) (screenWidth * marginRight);
        }

        if (marginTop > 0.0f) {
            params.topMargin = (int) (screenHeight * (marginTop));
        }

        if (marginBottom > 0.0f) {
            params.bottomMargin = (int) (screenHeight * marginBottom);
        }
        view.setLayoutParams(params);
    }

}
