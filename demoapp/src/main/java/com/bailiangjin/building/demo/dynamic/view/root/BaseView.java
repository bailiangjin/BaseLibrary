package com.bailiangjin.building.demo.dynamic.view.root;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.bailiangjin.building.demo.dynamic.bean.viewbean.base.BaseItem;

/**
 * 所有View的基类 根类
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 13:11
 */
abstract public class BaseView extends FrameLayout {

    private String mId;
    private String textContent;
    private String paramJson;

    protected Activity baseActivity;

    public BaseView(Context context, BaseItem baseItem) {
        super(context);
        if (context instanceof Activity) {
            this.baseActivity = (Activity) context;
        }
        LayoutInflater.from(context).inflate(getLayoutId(), this);
        initBase(baseItem);
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

    abstract protected void initBase(BaseItem baseItem);

    abstract protected void initView();

    abstract protected void initLogic();
}
