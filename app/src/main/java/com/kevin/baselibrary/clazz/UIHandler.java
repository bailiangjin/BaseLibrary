package com.kevin.baselibrary.clazz;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.kevin.baselibrary.interfaze.HandlerInterface;


public class UIHandler extends Handler
{

	private HandlerInterface handler;// 回调接口，消息传递给注册者

	public UIHandler(Looper looper)
	{
		super(looper);
	}

	public UIHandler(Looper looper, HandlerInterface handlerInterface)
	{
		super(looper);
		this.handler = handlerInterface;
	}

	public void setHandler(HandlerInterface handlerInterface)
	{
		this.handler = handlerInterface;
	}

	@Override
	public void handleMessage(Message msg)
	{
		super.handleMessage(msg);
		if (handler != null)
		{
			handler.handleMessage(msg);// 有消息，就传递
		}
	}
}
