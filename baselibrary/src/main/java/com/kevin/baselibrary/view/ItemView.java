package com.kevin.baselibrary.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kevin.baselibrary.R;


/**
 * 标题栏 抽象类
 */
public abstract class ItemView extends FrameLayout {

    private RelativeLayout rl_root;
    private TextView tv_left;
    private TextView tv_right;
    private ImageView iv_left;
    private ImageView iv_right;


    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_item_view, this);
        rl_root = (RelativeLayout) findViewById(R.id.rl_root);
        tv_left = (TextView) findViewById(R.id.tv_left);
        tv_right = (TextView) findViewById(R.id.tv_right);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);
        parseAttrs(context, attrs);

    }


    private void parseAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemView);
        setViewBackground(rl_root, R.styleable.ItemView_root_background, typedArray);
        setImageRes(iv_left, R.styleable.ItemView_left_iv_src, typedArray);
        setImageRes(iv_right, R.styleable.ItemView_right_iv_src, typedArray);

        setTvContent(tv_left, R.styleable.ItemView_left_text, typedArray);
        setTvContent(tv_right, R.styleable.ItemView_right_text, typedArray);

        setTextSize(tv_left, R.styleable.ItemView_left_text_size, typedArray);
        setTextSize(tv_right, R.styleable.ItemView_right_text_size, typedArray);

        setViewSize(iv_left, R.styleable.ItemView_left_iv_width, R.styleable.ItemView_left_iv_height,typedArray);
        setViewSize(iv_right, R.styleable.ItemView_right_iv_width, R.styleable.ItemView_right_iv_height,typedArray);

        setViewVisibility(tv_left, R.styleable.ItemView_left_text_visibility, typedArray, true);
        setViewVisibility(tv_right, R.styleable.ItemView_right_text_visibility, typedArray);

        setViewVisibility(iv_left, R.styleable.ItemView_left_iv_visibility, typedArray, true);
        setViewVisibility(iv_right, R.styleable.ItemView_right_iv_visibility, typedArray);

        typedArray.recycle();
    }

    private void setViewVisibility(View v, int styleableId, TypedArray typedArray) {
        boolean visibility = typedArray.getBoolean(styleableId, false);
        v.setVisibility(visibility ? VISIBLE : INVISIBLE);
    }

    private void setViewVisibility(View v, int styleableId, TypedArray typedArray, boolean defaultVisibility) {
        boolean visibility = typedArray.getBoolean(styleableId, defaultVisibility);
        v.setVisibility(visibility ? VISIBLE : INVISIBLE);
    }

    private void setTextSize(TextView textView, int styleableId, TypedArray typedArray) {
        float textSize = typedArray.getDimension(styleableId, -1f);
        if (textSize != -1f) {
            textView.setTextSize(textSize);
        }
    }

    private void setImageRes(ImageView iv, int styleableId, TypedArray typedArray) {
        int resId = typedArray.getResourceId(styleableId, -1);
        if (resId != -1) {
            iv.setImageResource(resId);
        }

    }

    private void setViewBackground(View v, int styleableId, TypedArray typedArray) {
        int resId = typedArray.getResourceId(styleableId, -1);
        if (resId != -1) {
            v.setBackgroundResource(resId);
        }

    }


    private void setTvContent(TextView tv, int styleableId, TypedArray typedArray) {
        String str = typedArray.getString(styleableId);
        if (!TextUtils.isEmpty(str)) {
            tv.setText(str);
        }
    }

    private void setViewSize(View view, int widthStyleableId, int heightStyleableId, TypedArray typedArray) {
        int width = (int) typedArray.getDimension(widthStyleableId, -1f);
        int height = (int) typedArray.getDimension(heightStyleableId, -1f);
        if (width == -1 || height == -1) {
            return;
        }
        setViewSize(view,width,height);

    }

    private void setLeftText(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        tv_left.setText(text);
    }

    private void setRightText(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        tv_right.setText(text);
    }

    private void setLeftIV(int resId) {
        if (0 == resId || -1 == resId) {
            return;
        }
        iv_left.setImageResource(resId);
    }

    private void setRightIV(int resId) {
        if (0 == resId || -1 == resId) {
            return;
        }
        iv_right.setImageResource(resId);
    }


    private void setViewSize(View view,int width, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        view.invalidate();
    }

    private void setLeftIvSize(int width, int height) {
        setViewSize(iv_left,width,height);
    }

    private void setRightIvSize(int width, int height) {
        setViewSize(iv_right,width,height);
    }





}