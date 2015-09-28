package com.kevin.baselibrary;

import android.os.Bundle;

import com.kevin.baselibrary.activiity.BaseActivity;

public class MainActivity extends BaseActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	@Override
	protected void onStart() {
		super.onStart();

		show("测试");
	}
}
