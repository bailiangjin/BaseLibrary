package com.kevin.building.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

import com.kevin.baselibrary.constant.SuperSPKey;
import com.kevin.baselibrary.utils.SPUtils;
import com.kevin.building.R;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.constants.LoginResult;

public class LoginActivity extends BaseActivity
{

	private EditText et_username;// 用户名
	private EditText et_password;// 密码
	private Button btn_login;// 登录按钮
	private CheckBox cb_save_password;
	private String userName = null;
	private String passWord = null;

	protected int getLayoutResId()
	{
		return R.layout.activity_login;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		initData();
		// LogUtils.d("手机型号：" + android.os.Build.MODEL);
		// longToastString("手机型号：" + android.os.Build.MODEL);
	}

	@Override
	protected void initView() {

		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(this);
		SPUtils.getString(getApplicationContext(), SuperSPKey.PASSWORD);
		boolean isChecked = (Boolean) SPUtils.get(getApplicationContext(), SuperSPKey.SAVEPWD, false);
		cb_save_password = (CheckBox) findViewById(R.id.cb_save_password);
		cb_save_password.setChecked(isChecked);
		cb_save_password.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				if (isChecked)
				{
					SPUtils.put(getApplicationContext(), SuperSPKey.SAVEPWD, true);
				}
				else
				{
					SPUtils.put(getApplicationContext(), SuperSPKey.SAVEPWD, false);
				}

			}
		});
	}

	@Override
	protected void initLogic() {

	}


	private void initData()
	{
		String userName = SPUtils.getString(getApplicationContext(), SuperSPKey.USER_NAME);
		if (!TextUtils.isEmpty(userName))
		{
			et_username.setText(userName);
		}
		String passWord = SPUtils.getString(getApplicationContext(), SuperSPKey.PASSWORD);
		if (!TextUtils.isEmpty(passWord))
		{
			et_password.setText(passWord);
		}
	}

	private boolean login()
	{
		show("点击了登录按钮");
		Intent intent = new Intent(this, UserListActivity.class);
		AppManager.getInstance().startActivity(LoginActivity.this, intent);
		return true;

	}

	@Override
	public void onViewClick(View v)
	{
		switch (v.getId())
		{
			case R.id.btn_login:
				userName = et_username.getText().toString().trim();
				passWord = et_password.getText().toString().trim();
				if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord))
				{
					show(R.string.username_pwd_cannot_be_null);
					return;
				}

				// TODO:执行登录逻辑
				boolean isLoginSuccess = login();
				if (isLoginSuccess)
				{

					SPUtils.putString(getApplicationContext(), SuperSPKey.USER_NAME, et_username.getText().toString().trim());

					if (cb_save_password.isChecked())
					{
						// TODO:密码加密后存放
						SPUtils.putString(getApplicationContext(), SuperSPKey.PASSWORD, et_password.getText().toString()
								.trim());
					}
					else
					{
						SPUtils.putString(getApplicationContext(), SuperSPKey.PASSWORD, "");
					}
				}

				break;

			default:
				break;

		}
	}

	@Override
	protected void handleMsg(Message msg)
	{
		switch (msg.what)
		{
			case LoginResult.SUCCESS:
				// TODO:进入下一个界面
				break;
			case LoginResult.FAILED:
				// TODO:登录失败 给出原因
				break;
			case LoginResult.ERRROR:
				// TODO:登录异常 给出提示
				break;
			default:
				break;
		}

	}

}
