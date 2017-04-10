package com.bailiangjin.simpleim.module.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.appcommon.base.BaseActivity;
import com.bailiangjin.simpleim.constants.IntentKey;
import com.bailiangjin.simpleim.utils.ActivityUtils;

import java.util.HashMap;

import butterknife.OnClick;

/**
 * 注册
 */
public class RegisterActivity extends BaseActivity
{
	private EditText et_username;
	private EditText et_password;
	private EditText et_confirm_pwd;


	public static void start(Activity activity){
		Intent intent = new Intent(activity,RegisterActivity.class);
		activity.startActivity(intent);
	}

	@Override
	protected int getLayoutResId()
	{
		return R.layout.activity_regist;
	}

	@Override
	protected void initIntentData() {

	}


	@Override
	protected void initView(Bundle savedInstanceState) {
		titleBarBuilder.setTitleText(getString(R.string.register));
		et_username= (EditText) findViewById(R.id.et_username);
		et_password= (EditText) findViewById(R.id.et_pwd);
		et_confirm_pwd= (EditText) findViewById(R.id.et_confirm_pwd);
	}

	@Override
	protected void initData(Bundle savedInstanceState) {

	}


	@OnClick({R.id.btn_regist,})
	public void onViewClick(View v)
	{
		switch (v.getId())
		{
			case R.id.btn_regist:

				String userName= et_username.getText().toString().trim();
				String password= et_password.getText().toString().trim();
				String confirm_password= et_confirm_pwd.getText().toString().trim();

				if (TextUtils.isEmpty(userName)){
					shortToast("用户名不能为空");
					break;
				}
				if (TextUtils.isEmpty(password)){
					shortToast("密码不能为空");
					break;
				}
				if (!password.equals(confirm_password)){
					shortToast("两次输入密码不一致");
					break;
				}


				shortToast("注册成功 回调到登录页");

				HashMap<String,String> paramMap= new HashMap<>();
				paramMap.put(IntentKey.IS_NEW_USER,"true");
				paramMap.put(IntentKey.USER_NAME,userName);
				paramMap.put(IntentKey.PASSWORD,password);

				ActivityUtils.startActivity(RegisterActivity.this,LoginActivity.class,paramMap);
				this.finish();
				break;

			default:
				break;
		}

	}

}
