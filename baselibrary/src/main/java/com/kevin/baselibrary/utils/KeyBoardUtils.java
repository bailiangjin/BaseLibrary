package com.kevin.baselibrary.utils;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.kevin.baselibrary.app.AppUtils;

/**
 * 打开或关闭软键盘
 * 
 * @author blj
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
	public static void closeKeyboard(View view)
	{
		InputMethodManager imm = (InputMethodManager) AppUtils.getContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);

		imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}


	/**
	 * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
	 *
	 * @param view
	 * @param motionEvent
	 * @return
	 */
	public static boolean isShouldHideInput(View view, MotionEvent motionEvent) {
		if (view != null && (view instanceof EditText)) {
			int[] l = { 0, 0 };
			view.getLocationInWindow(l);
			int left = l[0], top = l[1], bottom = top + view.getHeight(), right = left
					+ view.getWidth();
			if (motionEvent.getX() > left && motionEvent.getX() < right
					&& motionEvent.getY() > top && motionEvent.getY() < bottom) {
				// 点击EditText的事件，忽略它。
				return false;
			} else {
				return true;
			}
		}
		// 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
		return false;
	}
}
