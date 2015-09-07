package com.kevin.baselibrary.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.utils.ToastUtils;


public class MyTitleView extends FrameLayout
{

	private TextView tv_title;
	private Button btn_left;
	private Button btn_right;

	public MyTitleView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.my_title_view, this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		btn_left = (Button) findViewById(R.id.btn_left);
		btn_right = (Button) findViewById(R.id.btn_right);
		btn_left.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				((Activity) getContext()).finish();
			}
		});
		btn_right.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				ToastUtils.shortShowString(getContext(), "点击了设置按钮");
			}
		});
	}

	public void setTitleText(String text)
	{
		tv_title.setText(text);
	}

	public void setLeftBtnText(String text)
	{
		btn_left.setText(text);
	}

	public void setRightBtnText(String text)
	{
		btn_right.setText(text);
	}

	public void setLeftButtonListener(OnClickListener onClickListener)
	{
		btn_left.setOnClickListener(onClickListener);
	}

	public void setRightButtonListener(OnClickListener onClickListener)
	{
		btn_right.setOnClickListener(onClickListener);
	}

	public void setLeftBtnVisibility(int visibility)
	{
		btn_left.setVisibility(visibility);
	}

	public void setRightBtnVisibility(int visibility)
	{
		btn_right.setVisibility(visibility);
	}

}