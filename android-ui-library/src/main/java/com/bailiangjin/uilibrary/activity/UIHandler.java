package com.bailiangjin.uilibrary.activity;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;


public class UIHandler extends Handler {

    private UIHandlerListener uiHandlerListener;// 回调接口，消息传递给注册者

    public UIHandler(Looper looper) {
        super(looper);
    }

    public UIHandler(Looper looper, UIHandlerListener handleMsgListener) {
        super(looper);
        this.uiHandlerListener = handleMsgListener;
    }

    public void setListener(UIHandlerListener uiHandlerListener) {
        this.uiHandlerListener = uiHandlerListener;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (uiHandlerListener != null) {
            uiHandlerListener.handleMessage(msg);// 有消息，就传递
        }
    }
}
