package com.bailiangjin.utilslibrary.interfaze.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/9/29 15:38
 */
public class HomeEventListener {
    private Context mContext;
    private IntentFilter intentFilter;
    private OnHomePressedListener onHomePressedListener;
    private HomeBroadcastReceiver homeBroadcastReceiver;

    // 回调接口
    public interface OnHomePressedListener {
        public void onHomePressed();

        public void onHomeLongPressed();
    }

    public HomeEventListener(Context context) {
        mContext = context;
        intentFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
    }

    /**
     * 设置监听
     *
     * @param listener
     */
    public void setOnHomePressedListener(OnHomePressedListener listener) {
        onHomePressedListener = listener;
        homeBroadcastReceiver = new HomeBroadcastReceiver();
    }

    /**
     * 开始监听，注册广播
     */
    public void startWatch() {
        if (homeBroadcastReceiver != null) {
            mContext.registerReceiver(homeBroadcastReceiver, intentFilter);
        }
    }

    /**
     * 停止监听，注销广播
     */
    public void stopWatch() {
        if (homeBroadcastReceiver != null) {
            mContext.unregisterReceiver(homeBroadcastReceiver);
        }
    }

    class HomeBroadcastReceiver extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_KEY = "reason";
        final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
        final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
        final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                if (reason != null) {
                    //LogUtils.e( "action:" + action + ",reason:" + reason);
                    if (onHomePressedListener != null) {
                        if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
                            // 短按home键
                            onHomePressedListener.onHomePressed();
                        } else if (reason
                                .equals(SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                            // 长按home键
                            onHomePressedListener.onHomeLongPressed();
                        }
                    }
                }
            }
        }
    }
}