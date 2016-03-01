package com.kevin.baselibrary.utils.android;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.kevin.baselibrary.app.AppUtils;

/**
 * 打开或关闭软键盘
 * 
 * @author zhy
 * 
 */
public class KeyBoardUtils
{
	/**
	 * 打开软键盘
	 * 
	 * @param view
	 *            输入框
	 */
	public static void openKeybord(View view)
	{
		InputMethodManager imm = (InputMethodManager) AppUtils.getContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(view, InputMethodManager.RESULT_SHOWN);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
				InputMethodManager.HIDE_IMPLICIT_ONLY);
	}

	/**
	 * 关闭软键盘
	 * 
	 * @param view
	 *            输入框
	 */
	public static void closeKeybord(View view)
	{
		InputMethodManager imm = (InputMethodManager) AppUtils.getContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);

		imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}
}
