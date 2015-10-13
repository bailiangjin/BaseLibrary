package com.kevin.building.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.kevin.building.R;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BaseActivity;

public class UserListActivity extends BaseActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void initView() {
		titleView.setTitleText("联系人");
		titleView.setRightBtnText("添加");
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
	protected int getLayoutResID()
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
