package com.kevin.baselibrary.utils.uiutils;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.app.CtxUtils;
import com.kevin.baselibrary.utils.uiutils.callback.PNDialogListener;

/**
 * Dialog 工具类
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/10 17:29
 */
public class DialogUtils {

    /**
     * 展示 确认取消按钮 dialog 标题为 “提示” 按钮文字为 确认vs取消
     *
     * @param activity
     * @param message  内容描述
     * @param listener 按钮点击监听回调
     */
    public static void showPNDialog(final Activity activity, String message, final PNDialogListener listener) {
        showPNDialog(activity, CtxUtils.getString(R.string.notice), message, CtxUtils.getString(R.string.confirm), CtxUtils.getString(R.string.cancel), listener);
    }

    /**
     * 展示 确认取消按钮 dialog
     *
     * @param activity
     * @param title       标题
     * @param message     内容
     * @param positiveStr 确认字符
     * @param negativeStr 取消 对应字符
     * @param listener    按钮点击监听回调
     */
    public static void showPNDialog(final Activity activity, String title, String message, String positiveStr, String negativeStr, final PNDialogListener listener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton(positiveStr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                listener.onPositive(dialog, which);
            }
        });

        builder.setNegativeButton(negativeStr, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                listener.onNegative(dialog, which);
            }
        });
        builder.create().show();
    }
}
