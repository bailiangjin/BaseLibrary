package com.kevin.building.activity;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.utils.ActivityUtils;

/**
 * 添加联系人
 */
public class AddFriendActivity extends BaseActivity
{

	/**
	 * 添加按钮
	 */
	private Button btn_add;
	/**
	 * 退出按钮
	 */
	private Button btn_logout;


	@Override
	protected int getLayoutResId()
	{
		return R.layout.activity_addfriend;
	}


	@Override
	protected void initView() {
		commonTitleView.setTitleText(getString(R.string.addcontacts));
		commonTitleView.setRightBtnText(getString(R.string.user_info));

		btn_add = (Button) findViewById(R.id.btn_add);
		btn_logout = (Button) findViewById(R.id.btn_logout);

		btn_add.setOnClickListener(this);
		btn_logout.setOnClickListener(this);

		commonTitleView.setRightButtonListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						ActivityUtils.startActivity(AddFriendActivity.this,UserInfoActivity.class);
					}
				});

			}
		});
	}

	@Override
	protected void initLogic() {

	}


	@Override
	protected void onStart()
	{

		super.onStart();
	}

	@Override
	protected void onStop()
	{

		super.onStop();
	}

	@Override
	protected void onDestroy()
	{

		super.onDestroy();

	}


	@Override
	public void onViewClick(View v)
	{
		switch(v.getId()){
			case R.id.btn_add:
				shortToast("添加");
				break;
			case R.id.btn_logout:
				shortToast("登出");
				ActivityUtils.startActivity(AddFriendActivity.this, LogoutActivity.class);
				break;

			default:
				break;
		}
	}

	@Override
	protected void handleMsg(Message msg)
	{
		// TODO Auto-generated method stub

	}

}
