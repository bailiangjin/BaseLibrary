package com.bailiangjin.simpleim;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.bailiangjin.simpleim.base.BaseActivity;
import com.kevin.baselibrary.app.AppUtils;

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
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		//跳转到 主页
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				//LoginActivity.start(SplashActivity.this);

				MainActivity.start(SplashActivity.this);
				SplashActivity.this.finish();



			}
		}, 1000);

	}

	@Override
	protected void initView() {
		hideCommonBaseTitle();
		tv_app_version_name = (TextView) findViewById(R.id.tv_app_version_name);
	}

	@Override
	protected void initData() {
		tv_app_version_name.setText(AppUtils.getCurrentAppVersionName());
	}






}
