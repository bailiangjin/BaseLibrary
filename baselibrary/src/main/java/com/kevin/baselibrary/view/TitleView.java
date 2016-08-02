package com.kevin.baselibrary.view;

import android.content.Context;
import android.util.AttributeSet;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.view.base.BaseTitleView;


public class TitleView extends BaseTitleView {


    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getTitleBackgroundResId() {
        return R.drawable.title_gradient_bg;
    }

    @Override
    protected int getTitleTvSize() {
        return 18;
    }

    @Override
    protected int getBtnTvSize() {
        return 14;
    }

    @Override
    protected int getTitleTvColor() {
        return R.color.white;
    }

    @Override
    protected int getBtnTvColor() {
        return R.color.white;
    }

    @Override
    protected int getLeftImageResId() {
        return R.drawable.ic_arrow_back_white_36dp;
    }

    @Override
    protected int getRightImageResId() {
        return 0;
    }

    @Override
    protected int getRightImage2ResId() {
        return 0;
    }

    @Override
    protected int getLeftBtnResId() {
        return R.color.transparent;
    }

    @Override
    protected int getRightBtnResId() {
        return R.color.transparent;
    }

    @Override
    protected int getBtnWidth() {
        return 68;
    }

    @Override
    protected int getBtnHeight() {
        return 36;
    }

    @Override
    protected boolean getLeftImgVisibility() {
        return true;
    }

    @Override
    protected boolean getRightImgVisibility() {
        return false;
    }

    @Override
    protected boolean getRightImg2Visibility() {
        return false;
    }

    @Override
    protected boolean getRightBtnVisibility() {
        return false;
    }

    @Override
    protected boolean getLeftBtnVisibility() {
        return false;
    }

}