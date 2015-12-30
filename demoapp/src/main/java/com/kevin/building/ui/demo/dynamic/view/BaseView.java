package com.kevin.building.ui.demo.dynamic.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 13:11
 */
abstract public class BaseView extends FrameLayout {

    private String mId;
    private String textContent;
    private String paramJson;

    public BaseView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(getLayoutId(), this);
        initView();
        initLogic();
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getParamJson() {
        return paramJson;
    }

    public void setParamJson(String paramJson) {
        this.paramJson = paramJson;
    }

    abstract protected int getLayoutId();

    abstract protected void initView();

    abstract protected void initLogic();
}
