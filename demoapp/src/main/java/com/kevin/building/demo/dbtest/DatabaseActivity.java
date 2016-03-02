package com.kevin.building.demo.dbtest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.db.dao.PersonDao;
import com.kevin.building.db.modle.Person;

public class DatabaseActivity extends BaseActivity
{

	private Handler dbHandler = null;

	private static final int INSERT_USER_MSG_WHAT = 101;
	private static final int UPDATE_USER_MSG_WHAT = 102;
	private static final int DELETE_USER_MSG_WHAT = 103;
	private static final int SEARCH_USER_MSG_WHAT = 104;

	@Override
	protected int getLayoutResId()
	{
		return R.layout.activity_database;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		initHandler();
	}

	@Override
	protected void initView() {
		titleView.setTitleText("测试数据库");
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

	// 以上为 Anctivity 生命周期 逻辑
	// ------------------------------------------------------------------

	// 以下为 其他业务逻辑
	// ------------------------------------------------------------------

	public void onClick_insert(View v)
	{

		LogUtils.d("执行插入操作");

	}

	public void onClick_update(View v)
	{

		LogUtils.d("执行更新操作");

	}

	public void onClick_delete(View v)
	{

		LogUtils.d("执行删除操作");

	}

	public void onClick_search(View v)
	{

		LogUtils.d("执行搜索操作");

	}

	/**
	 * 初始化handler
	 */
	private void initHandler()
	{
		dbHandler = new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				switch (msg.what)
				{
					case INSERT_USER_MSG_WHAT:

						if (null != msg.obj && msg.obj instanceof Person)
						{
							PersonDao dao = PersonDao.getInstance(DatabaseActivity.this);
							if (dao.insert((Person) msg.obj))
							{
								LogUtils.d("插入数据成功：" + Person.class.getName());
							}
						}
						else
						{
							LogUtils.e("插入数据类型错误,为null或不是：" + Person.class.getName());
						}

						break;
					case UPDATE_USER_MSG_WHAT:
						break;
					case DELETE_USER_MSG_WHAT:
						break;
					case SEARCH_USER_MSG_WHAT:
						break;

					default:
						break;
				}
				super.handleMessage(msg);
			}
		};
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
