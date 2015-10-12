package com.kevin.baselibrary.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.kevin.baselibrary.interfaze.HandleMsgListener;


public class UIHandler extends Handler
{

	private HandleMsgListener handleMsgListener;// 回调接口，消息传递给注册者

	public UIHandler(Looper looper)
	{
		super(looper);
	}

	public UIHandler(Looper looper, HandleMsgListener handleMsgListener)
	{
		super(looper);
		this.handleMsgListener = handleMsgListener;
	}

	public void setListener(HandleMsgListener handlMsgListener)
	{
		this.handleMsgListener = handlMsgListener;
	}

	@Override
	public void handleMessage(Message msg)
	{
		super.handleMessage(msg);
		if (handleMsgListener != null)
		{
			handleMsgListener.handleMessage(msg);// 有消息，就传递
		}
	}
}
