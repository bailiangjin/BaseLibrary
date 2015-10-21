package com.kevin.baselibrary.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

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
	 * @param mEditText
	 *            输入框
	 */
	public static void openKeybord(EditText mEditText)
	{
		InputMethodManager imm = (InputMethodManager) AppUtils.getContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
				InputMethodManager.HIDE_IMPLICIT_ONLY);
	}

	/**
	 * 关闭软键盘
	 * 
	 * @param mEditText
	 *            输入框
	 */
	public static void closeKeybord(EditText mEditText)
	{
		InputMethodManager imm = (InputMethodManager) AppUtils.getContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);

		imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
	}
}
