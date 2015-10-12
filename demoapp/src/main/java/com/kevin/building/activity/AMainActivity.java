package com.kevin.building.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.NetUtils;
import com.kevin.building.R;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.utils.ActivityUtils;

public class AMainActivity extends BaseActivity
{

	private long lastTouchTime = 0;
	private long gapTime = 2000;

	@Override
	protected int getLayoutResID() {
		return R.layout.activity_main;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		initView();
		LogUtils.e("mytype:nettype:" + NetUtils.getNetWorkType().toString());
		LogUtils.e("mytype:providerType:"+ NetUtils.getProviderType().toString());
	}



	private void initView()
	{
		// titleView.setRightBtnVisibility(View.GONE);
		titleView.setTitleText("主页面");
		titleView.setLeftBtnVisibility(View.GONE);
		titleView.setRightBtnText("注册");
		titleView.setRightButtonListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(AMainActivity.this, RegistActivity.class);

				AppManager.getInstance().startActivity(AMainActivity.this, intent);

			}
		});

	}

	public void onClick_btn_fragment(View v)
	{
		Intent intent = new Intent(this, MyFragmentActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.activity_in, R.anim.activity_out);

	}

	public void onClick_btn_test_db(View v)
	{
		ActivityUtils.startDatabaseActivity(AMainActivity.this);
	}

	public void onClick_btn_test_login(View v)
	{
		Intent intent = new Intent(this, LoginActivity.class);
		AppManager.getInstance().startActivity(AMainActivity.this, intent);
	}

	public void onClick_btn_test_user(View v)
	{
		Intent intent = new Intent(this, UserInfoActivity.class);
		AppManager.getInstance().startActivity(AMainActivity.this, intent);
	}

	@Override
	public void onBackPressed()
	{
		long currentTime = System.currentTimeMillis();
		if (currentTime - lastTouchTime > gapTime)
		{
			show(R.string.one_more_click_exit);
			lastTouchTime = currentTime;
			return;
		}
		else
		{
			finish();
		}

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
