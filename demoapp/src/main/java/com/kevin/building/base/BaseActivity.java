package com.kevin.building.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;

import com.kevin.baselibrary.base.SuperBaseActivity;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.NetUtils;
import com.kevin.baselibrary.view.MyTitleView;
import com.kevin.building.R;
import com.kevin.building.app.AppManager;

public abstract class BaseActivity extends SuperBaseActivity
{

	public static final String ACTION_NETWORK_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
	public static final String ACTION_PUSH_DATA = "fm.data.push.action";
	public static final String ACTION_NEW_VERSION = "apk.update.action";

	protected MyTitleView titleView;



	protected BroadcastReceiver receiver = new BroadcastReceiver()
	{
		@Override
		public void onReceive(Context context, Intent intent)
		{
			onBroadcast(intent);
		}

	};

	@Override
	protected void onNewIntent(Intent intent)
	{
		LogUtils.d("Activity:::-->>onNewIntent");
		super.onNewIntent(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		LogUtils.d("Activity:::-->>onCreate");
		super.onCreate(savedInstanceState);

		AppManager.getInstance().addActivity(this);
	}

	@Override
	protected void onRestart()
	{
		LogUtils.d("Activity:::-->>onRestart");
		super.onRestart();
	}

	@Override
	protected void onStart()
	{
		LogUtils.d("Activity:::-->>onStart");
		super.onStart();
	}

	@Override
	protected void onResume()
	{
		LogUtils.d("Activity:::-->>onResume");
		super.onResume();

		registBroadCastReceiver();
	}

	@Override
	protected void onPause()
	{
		LogUtils.d("Activity:::-->>onPause");
		super.onPause();
	}

	@Override
	protected void onStop()
	{
		LogUtils.d("Activity:::-->>onStop");
		super.onStop();
	}

	@Override
	protected void onDestroy()
	{
		LogUtils.d("Activity:::-->>onDestroy");
		super.onDestroy();
		unRegistBroadCastReceiver();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		LogUtils.d("Activity:::-->>onActivityResult");
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void initBaseView()
	{
		titleView = (MyTitleView) findViewById(R.id.title_view);
	}





	/**
	 * 网络连接上
	 * 
	 */
	protected void onNetConnected()
	{
		String connectType;
		if (NetUtils.isWifiConnect(getApplicationContext()))
		{
			connectType = "WiFi";

		}
		else
		{
			connectType = "手机网络";
		}
		show("网络已经连接 连接类型：" + connectType);
	}

	/**
	 * 网络断开
	 * 
	 */
	protected void onNetDisConnected()
	{
		show("网络已经断开");
	}






	@Override
	public void onBackPressed()
	{
		finish();
		overridePendingTransition(R.anim.activity_edit_in, R.anim.activity_edit_out);
		super.onBackPressed();
	}

	/**
	 * 横竖屏切换，键盘等
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
	}

	/**
	 * 注册广播监听
	 */
	private void registBroadCastReceiver()
	{
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(ACTION_NETWORK_CHANGE);
		intentFilter.addAction(ACTION_PUSH_DATA);
		intentFilter.addAction(ACTION_NEW_VERSION);
		registerReceiver(receiver, intentFilter);

	}

	/**
	 * 注销广播监听
	 */
	private void unRegistBroadCastReceiver()
	{
		if (null != receiver)
		{
			unregisterReceiver(receiver);
		}

	}

	/**
	 * 处理广播事件
	 * 
	 * @param intent
	 */
	private void onBroadcast(Intent intent)
	{
		// 处理各种情况
		String action = intent.getAction();
		// if (ACTION_NETWORK_CHANGE.equals(action))
		// { // 网络发生变化
		// LogUtils.d("网络状况变化");
		// if (NetUtils.isConnect(getApplicationContext()))
		// {
		// onNetConnected();
		// }
		// else
		// {
		// onNetDisConnected();
		// }
		// }
		// else
		if (ACTION_PUSH_DATA.equals(action))
		{ // 可能有新数据
			// Bundle b = intent.getExtras();
			// MData<Employee> mdata = (MData<Employee>) b.get("data");
			// if (dataCallback != null)
			// { // 数据通知
			// dataCallback.onNewData(mdata);
			// }
		}
		else if (ACTION_NEW_VERSION.equals(action))
		{ // 可能发现新版本
			// VersionDialog 可能是版本提示是否需要下载的对话框
		}
	}

	// 工具方法
	// --------------------------------------------------------------------------------



}
