package com.kevin.building.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.utils.ActivityUtils;

public class SplashActivity extends BaseActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		//跳转到 主页
		new Handler().postDelayed(new Runnable()
		{

			@Override
			public void run()
			{
				ActivityUtils.startAMainActivity(SplashActivity.this);
				SplashActivity.this.finish();

			}
		}, 300);

	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initLogic() {

	}

	@Override
	protected int getLayoutResId()
	{
		return R.layout.activity_splash;
	}

	@Override
	public void onViewClick(View v)
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void handleMsg(Message msg)
	{
		// TODO Auto-generated method stub

	}
}
