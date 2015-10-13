package com.kevin.building.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.kevin.baselibrary.utils.AppUtil;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.utils.ActivityUtils;

public class SplashActivity extends BaseActivity
{

	private TextView tv_app_version_name;

	@Override
	protected int getLayoutResId()
	{
		return R.layout.activity_splash;
	}


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
		}, 1000);

	}

	@Override
	protected void initView() {

		tv_app_version_name = (TextView) findViewById(R.id.tv_app_version_name);
	}

	@Override
	protected void initLogic() {
		tv_app_version_name.setText(AppUtil.getCurrentAppVersionName());
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
