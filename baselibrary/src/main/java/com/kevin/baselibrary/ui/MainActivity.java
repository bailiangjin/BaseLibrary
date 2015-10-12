package com.kevin.baselibrary.ui;

import android.os.Bundle;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.base.SuperBaseActivity;

public class MainActivity extends SuperBaseActivity
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
