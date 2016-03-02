package com.kevin.baselibrary.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.interfaze.listener.TitleViewListener;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;


public class TitleView extends FrameLayout {

    private TextView tv_title;
    private Button btn_left;
    private Button btn_right;

    private TitleViewListener titleViewListener;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_title_view, this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);
        btn_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果监听为空 或未覆盖事件 则结束Activity
                if (!isListenerInit() || !titleViewListener.onLeftBtnClick()) {
                    ((Activity) getContext()).finish();
                    return;
                }


            }
        });
        btn_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isListenerInit()) {
                    return;
                }
                if (titleViewListener.onRightBtnClick()) {
                    return;
                } else {
                    ToastUtils.show("点击了" + btn_right.getText().toString());
                }

            }
        });


    }

    private boolean isListenerInit() {
        if (null == titleViewListener) {
            LogUtils.e("please set titleView listener");
            return false;
        }
        return true;
    }

    public void setTitleViewListener(TitleViewListener titleViewListener) {
        this.titleViewListener = titleViewListener;
    }

    public void setTitleText(String text) {
        tv_title.setText(text);
    }

    public void setLeftBtnText(String text) {
        btn_left.setText(text);
    }

    public void setRightBtnText(String text) {
        btn_right.setText(text);
    }

    public void setLeftButtonListener(OnClickListener onClickListener) {
        btn_left.setOnClickListener(onClickListener);
    }

    public void setRightButtonListener(OnClickListener onClickListener) {
        btn_right.setOnClickListener(onClickListener);
    }

    public void setLeftBtnVisibility(int visibility) {
        btn_left.setVisibility(visibility);
    }

    public void setRightBtnVisibility(int visibility) {
        btn_right.setVisibility(visibility);
    }

}