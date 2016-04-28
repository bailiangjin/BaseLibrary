package com.kevin.building.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.kevin.building.R;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BaseActivity;

/**
 * 用户列表页
 */
public class UserListActivity extends BaseActivity
{



	@Override
	protected void initView() {
		titleView.setTitleText(getString(R.string.contacts));
		titleView.setRightBtnText(getString(R.string.add));
		titleView.setRightButtonListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(UserListActivity.this, AddFriendActivity.class);
				AppManager.getInstance().startActivity(UserListActivity.this, intent);
			}
		});
	}

	@Override
	protected void initLogic() {

	}


	@Override
	protected int getLayoutResId()
	{
		return R.layout.activity_userlist;
	}

	@Override
	protected void handleMsg(Message msg)
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void onViewClick(View v)
	{
		// TODO Auto-generated method stub

	}

}
