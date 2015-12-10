package com.kevin.building.ui.demo.fragmentdemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.WindowManager;

import com.kevin.baselibrary.base.SuperBaseFragment;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.ui.fragment.Fragment1;
import com.kevin.building.ui.fragment.Fragment2;

public class MyFragmentActivity extends BaseActivity
{

	private Fragment1 fragment1;
	private Fragment2 fragment2;

	private static final int FRAGMENT_1_MSG_WHAT = 0;
	private static final int FRAGMENT_2_MSG_WHAT = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		WindowManager wm = getWindowManager();

		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fm.beginTransaction();
		if (width < height)
		{
			fragmentTransaction.replace(android.R.id.content, getFragment1());
		}
		else
		{
			fragmentTransaction.replace(android.R.id.content, getFragment2());
		}
		fragmentTransaction.commit();

	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initLogic() {

	}

	@Override
	protected int getLayoutResId() {
		return 0;
	}

	@Override
	protected void onViewClick(View v) {

	}

	@Override
	protected void handleMsg(Message msg) {

	}

	Handler handler = new Handler()
	{
		@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
		public void handleMessage(Message msg)
		{
			if (isDestroyed())
			{
				return;
			}
			switch (msg.what)
			{
				case FRAGMENT_1_MSG_WHAT:

					replaceFragment(getFragment1());
					break;
				case FRAGMENT_2_MSG_WHAT:
					replaceFragment(getFragment2());
					break;

				default:
					break;
			}
		};
	};

	@Override
	protected void onStart()
	{
		super.onStart();
		new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				for (int i = 0; i < 10000; i++)
				{
					if (i % 2 == 1)
					{
						Message msg = handler.obtainMessage(FRAGMENT_1_MSG_WHAT);
						handler.sendMessage(msg);
					}
					else
					{
						Message msg = handler.obtainMessage(FRAGMENT_2_MSG_WHAT);
						handler.sendMessage(msg);
					}
					try
					{
						Thread.sleep(2000);
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}).start();

	}

	private void replaceFragment(SuperBaseFragment fragment)
	{
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fm.beginTransaction();
		fragmentTransaction.replace(android.R.id.content, fragment);
		fragmentTransaction.commit();
	}

	public Fragment1 getFragment1()
	{
		if (fragment1 == null)
		{
			fragment1 = new Fragment1();
		}
		return fragment1;
	}

	public Fragment2 getFragment2()
	{
		if (fragment2 == null)
		{
			fragment2 = new Fragment2();
		}
		return fragment2;
	}

}
