package com.kevin.building.activity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.kevin.baselibrary.utils.SPUtils;
import com.kevin.building.R;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.constants.SPKey;

public class LogoutActivity extends BaseActivity
{

	private Button btn_set_manageuser;
	private Button btn_set_cancel;
	private Button btn_set_logout;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		initView();
	}

	private void initView()
	{
		titleView.setTitleText("注销");
		titleView.setRightBtnVisibility(View.GONE);
		btn_set_manageuser = (Button) findViewById(R.id.btn_set_manageuser);
		btn_set_cancel = (Button) findViewById(R.id.btn_set_cancel);
		btn_set_logout = (Button) findViewById(R.id.btn_set_logout);
		btn_set_manageuser.setOnClickListener(this);
		btn_set_cancel.setOnClickListener(this);
		btn_set_logout.setOnClickListener(this);
	}

	@Override
	protected int getLayoutViewResID()
	{
		return R.layout.activity_logout;
	}

	@Override
	protected void handleMsg(Message msg)
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void widgetClick(View v)
	{
		switch (v.getId())
		{
			case R.id.btn_set_cancel:
				this.finish();
				break;
			case R.id.btn_set_logout:
				// 用户登出逻辑添加
				// SPUtils.remove(getApplicationContext(), SPKey.USER_NAME);
				SPUtils.remove(getApplicationContext(), SPKey.PASSWORD);
				SPUtils.remove(getApplicationContext(), SPKey.SAVEPWD);
				AppManager.getInstance().AppExit(getApplicationContext());
				this.finish();
				break;
			case R.id.btn_set_manageuser:
				// TODO:用户管理逻辑添加
				break;

			default:
				break;
		}

	}

}
