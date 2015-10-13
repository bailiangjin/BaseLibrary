package com.kevin.baselibrary.model.art;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.kevin.baselibrary.interfaze.listener.UIHandlerListener;


public class UIHandler extends Handler
{

	private UIHandlerListener uiHandlerListener;// 回调接口，消息传递给注册者

	public UIHandler(Looper looper)
	{
		super(looper);
	}

	public UIHandler(Looper looper, UIHandlerListener handleMsgListener)
	{
		super(looper);
		this.uiHandlerListener = handleMsgListener;
	}

	public void setListener(UIHandlerListener handlMsgListener)
	{
		this.uiHandlerListener = handlMsgListener;
	}

	@Override
	public void handleMessage(Message msg)
	{
		super.handleMessage(msg);
		if (uiHandlerListener != null)
		{
			uiHandlerListener.handleMessage(msg);// 有消息，就传递
		}
	}
}
