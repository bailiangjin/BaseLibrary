package com.kevin.baselibrary.activity;

import android.os.Bundle;
import android.view.View;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.base.SuperBaseActivity;

public class MainActivity extends SuperBaseActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	protected int getLayoutResID() {
		return R.layout.activity_main;
	}




	@Override
	protected void onStart() {
		super.onStart();

		show("测试");
	}


	@Override
	protected void onViewClick(View v) {

	}
}