package com.kevin.building;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.kevin.baselibrary.app.AppUtils;
import com.kevin.building.base.BaseActivity;

/**
 * Splash页
 */
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
				MainActivity.start(SplashActivity.this);
				SplashActivity.this.finish();
			}
		}, 1000);

	}

	@Override
	protected void initView() {

		tv_app_version_name = (TextView) findViewById(R.id.tv_app_version_name);
	}

	@Override
	protected void initData() {
		tv_app_version_name.setText(AppUtils.getCurrentAppVersionName());
	}



	@Override
	public void onViewClick(View v)
	{
		// TODO Auto-generated method stub

	}


}
