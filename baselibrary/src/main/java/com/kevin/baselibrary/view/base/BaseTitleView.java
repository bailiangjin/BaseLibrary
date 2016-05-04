package com.kevin.baselibrary.view.base;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.interfaze.listener.TitleViewListener;
import com.kevin.baselibrary.utils.DensityUtils;
import com.kevin.baselibrary.utils.LogUtils;

/**
 * 标题栏 抽象类
 */
public abstract class BaseTitleView extends FrameLayout {

    private RelativeLayout rl_root;
    private TextView tv_title;
    private ImageView iv_left;
    private ImageView iv_right;
    private Button btn_left;
    private Button btn_right;

    private TitleViewListener titleViewListener;

    public BaseTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_title_view, this);
        rl_root = (RelativeLayout) findViewById(R.id.rl_root);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);
        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);

        //整体背景
        if (0 != getTitleBackgroundResId()) {
            rl_root.setBackground(getResources().getDrawable(getTitleBackgroundResId()));
        }


        //按钮背景
        if (0 != getLeftImageResId()) {
            iv_left.setImageResource(getLeftImageResId());//该种方式动态设置背景 不会变形
        }

        if (0 != getRightImageResId()) {
            iv_right.setImageResource(getRightImageResId());//该种方式动态设置背景 不会变形
        }
        if (0 != getLeftBtnResId()) {
            btn_left.setBackground(getResources().getDrawable(getLeftBtnResId()));
        }

        if (0 != getRightBtnResId()) {
            btn_right.setBackground(getResources().getDrawable(getRightBtnResId()));
        }


        //字体大小
        if (getTitleTvSize() > 0) {
            tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, getTitleTvSize());
        }

        if (getBtnTvSize() > 0) {
            btn_left.setTextSize(TypedValue.COMPLEX_UNIT_SP, getBtnTvSize());
            btn_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, getBtnTvSize());
        }

        //按钮宽度
        if (getBtnWidth() > 0&& getBtnHeight()>0) {
            setLeftBtnSize(getBtnWidth(),getBtnHeight());
            setRightBtnSize(getBtnWidth(),getBtnHeight());
        }

        if (getBtnTvSize() > 0) {
            btn_left.setTextSize(TypedValue.COMPLEX_UNIT_SP, getBtnTvSize());
            btn_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, getBtnTvSize());
        }

        //文字颜色
        if (0 != getTitleTvColor()) {
            tv_title.setTextColor(getResources().getColor(getTitleTvColor()));
        }

        if (0 != getBtnTvColor()) {
            btn_left.setTextColor(getResources().getColor(getBtnTvColor()));
            btn_right.setTextColor(getResources().getColor(getBtnTvColor()));
        }


        //按钮可见性
        iv_left.setVisibility(getLeftImgVisibility() ? View.VISIBLE : View.GONE);
        iv_right.setVisibility(getRightImgVisibility() ? View.VISIBLE : View.GONE);
        btn_left.setVisibility(getLeftBtnVisibility() ? View.VISIBLE : View.GONE);
        btn_right.setVisibility(getRightBtnVisibility() ? View.VISIBLE : View.GONE);


        //按钮监听事件
        iv_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果监听为空 或未覆盖事件 则结束Activity
                if (!isListenerInit() || !titleViewListener.onLeftImgClick()) {
                    ((Activity) getContext()).finish();
                    return;
                }


            }
        });

        //按钮监听事件
        iv_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isListenerInit()) {
                    return;
                }
                if (titleViewListener.onRightImgClick()) {
                    return;
                } else {
                    //do some thing
                }


            }
        });

        //按钮监听事件
        btn_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isListenerInit()) {
                    return;
                }
                if (titleViewListener.onLeftBtnClick()) {
                    return;
                } else {
                    //ToastUtils.shortToast("点击了" + btn_right.getText().toString());
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
                    //ToastUtils.shortToast("点击了" + btn_right.getText().toString());
                }

            }
        });


    }

    private void setLeftBtnSize(int width,int height) {
        ViewGroup.LayoutParams layoutParams;
        layoutParams = btn_left.getLayoutParams();
        layoutParams.height = DensityUtils.dip2px(height);
        layoutParams.width = DensityUtils.dip2px(width);
        btn_left.setLayoutParams(layoutParams);
    }

    private void setRightBtnSize(int width,int height) {
        ViewGroup.LayoutParams layoutParams;
        layoutParams = btn_right.getLayoutParams();
        layoutParams.height = DensityUtils.dip2px(height);
        layoutParams.width = DensityUtils.dip2px(width);
        btn_right.setLayoutParams(layoutParams);
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

    public void setLeftImageVisibility(int visibility) {
        iv_left.setVisibility(visibility);
    }

    public void setRightImageVisibility(int visibility) {
        iv_right.setVisibility(visibility);
    }

    public void setLeftBtnVisibility(int visibility) {
        btn_left.setVisibility(visibility);
    }

    public void setRightBtnVisibility(int visibility) {
        btn_right.setVisibility(visibility);
    }

    public void setBackBtnClickable(boolean clickable) {
        iv_left.setClickable(clickable);
    }


    public void setLeftBtnClickable(boolean clickable) {
        btn_left.setClickable(clickable);
    }

    public void setRightBtnClickable(boolean clickable) {
        btn_right.setClickable(clickable);
    }


    /**
     * 标题栏整体背景
     *
     * @return
     */
    protected abstract int getTitleBackgroundResId();

    /**
     * 标题文字字体大小 sp 使用默认请返回0
     *
     * @return
     */
    protected abstract int getTitleTvSize();

    /**
     * 按钮文字字体大小
     *
     * @return
     */
    protected abstract int getBtnTvSize();

    /**
     * 标题文字颜色 int值
     *
     * @return
     */
    protected abstract int getTitleTvColor();

    /**
     * 按钮文字颜色 int值
     *
     * @return
     */
    protected abstract int getBtnTvColor();

    /**
     * 左侧图标背景 资源文件id
     *
     * @return
     */
    protected abstract int getLeftImageResId();


    /**
     * 右侧图标背景 资源文件id
     *
     * @return
     */
    protected abstract int getRightImageResId();

    /**
     * 左侧按钮背景
     *
     * @return
     */
    protected abstract int getLeftBtnResId();

    /**
     * 右侧按钮背景
     *
     * @return
     */
    protected abstract int getRightBtnResId();

    /**
     * 按钮宽度
     *
     * @return
     */
    protected abstract int getBtnWidth();

    /**
     * 按钮高度
     *
     * @return
     */
    protected abstract int getBtnHeight();

    /**
     * 左侧图标可见性
     *
     * @return
     */
    protected abstract boolean getLeftImgVisibility();

    /**
     * 右侧侧图标可见性
     *
     * @return
     */
    protected abstract boolean getRightImgVisibility();

    /**
     * 右侧按钮可见性
     *
     * @return
     */
    protected abstract boolean getRightBtnVisibility();

    /**
     * 左侧按钮可见性
     *
     * @return
     */
    protected abstract boolean getLeftBtnVisibility();

}