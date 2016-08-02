package com.bailiangjin.simpleim.appui.account;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.base.BaseActivity;


/**
 * 用户信息页
 */
public class UserInfoActivity extends BaseActivity
{

	private Button btn_userinfo_back;


	public static void start(Activity activity){
		Intent intent = new Intent(activity,UserInfoActivity.class);
		activity.startActivity(intent);
	}


	@Override
	protected void initView() {
		commonTitleView.setTitleText(getString(R.string.friend_info));
		btn_userinfo_back = (Button) findViewById(R.id.btn_userinfo_back);
		btn_userinfo_back.setOnClickListener(this);
	}

	@Override
	protected void initData() {

	}


	@Override
	protected int getLayoutResId()
	{
		return R.layout.activity_user_info;
	}



	@Override
	protected void onViewClick(View v)
	{
		switch (v.getId())
		{
			case R.id.btn_userinfo_back:

				this.finish();
				break;

			default:
				break;
		}

	}

}
