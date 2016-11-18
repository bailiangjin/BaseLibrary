package com.kevin.building;

import android.os.Handler;
import android.widget.TextView;

import com.kevin.baselibrary.app.AppUtils;
import com.kevin.building.activity.TestDeviceActivity;
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
	protected void initIntentData() {

	}


	@Override
	protected void initView() {

		hideCommonBaseTitle();
		tv_app_version_name = (TextView) findViewById(R.id.tv_app_version_name);
	}

	@Override
	protected void initData() {
		tv_app_version_name.setText(AppUtils.getCurrentAppVersionName());

		//跳转到 主页
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
//				MainActivity.start(SplashActivity.this);
				TestDeviceActivity.start(SplashActivity.this);
				SplashActivity.this.finish();
			}
		}, 1000);

	}





}
