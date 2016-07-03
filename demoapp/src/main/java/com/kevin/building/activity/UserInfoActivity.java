package com.kevin.building.activity;

import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

/**
 * 用户信息页
 */
public class UserInfoActivity extends BaseActivity
{

	private Button btn_userinfo_back;


	@Override
	protected void initView() {
		commonTitleView.setTitleText(getString(R.string.friend_info));
		btn_userinfo_back = (Button) findViewById(R.id.btn_userinfo_back);
		btn_userinfo_back.setOnClickListener(this);
	}

	@Override
	protected void initLogic() {

	}


	@Override
	protected int getLayoutResId()
	{
		return R.layout.activity_user_info;
	}

	@Override
	protected void handleMsg(Message msg)
	{
		// TODO Auto-generated method stub

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
