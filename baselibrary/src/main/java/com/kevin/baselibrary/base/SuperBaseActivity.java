package com.kevin.baselibrary.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;

import com.kevin.baselibrary.constant.SuperBroadcastAction;
import com.kevin.baselibrary.interfaze.listener.UIHandlerListener;
import com.kevin.baselibrary.model.art.HomeEventListener;
import com.kevin.baselibrary.model.art.UIHandler;
import com.kevin.baselibrary.net.NetUtils;
import com.kevin.baselibrary.utils.KeyBoardUtils;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;

import java.util.Set;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/9/28 23:10
 */
public abstract class SuperBaseActivity extends FragmentActivity implements View.OnClickListener {


    /**
     * Handler 消息处理
     */
    protected UIHandler handler = new UIHandler(Looper.getMainLooper());

    /**
     * Home键时间监听
     */
    protected HomeEventListener homeEventListener;

    /**
     * 全局广播监听
     */
    protected BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            onSuperBroadcast(intent);
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化根类UI
        initSuperUI();
        //初始化 子类BaseActivity UI
        initBaseUI();
        //初始化子类(具体Activity)布局
        initView();
        //初始化父类逻辑
        initSuperLogic();
        //初始化子类逻辑
        initLogic();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始执行子类逻辑
        startLogic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        homeEventListener.startWatch();
        registerBroadCastReceiver();
    }


    @Override
    protected void onPause() {
        super.onPause();
        homeEventListener.stopWatch();
        unRegisterBroadCastReceiver();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        onViewClick(v);
    }

    /**
     * 全局事件分发 实现 触摸非输入框控件 隐藏键盘
     *
     * @param motionEvent
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View view = getCurrentFocus();

            if (KeyBoardUtils.isShouldHideInput(view, motionEvent)) {
                KeyBoardUtils.closeKeybord(view);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }


    /**
     * 当前类实现当前类调用方法----------------------------------start----------------------------------
     */


    /**
     * 初始化父类UI
     */
    private void initSuperUI() {
        //初始化根布局
        initRootLayout();
    }

    /**
     * 初始化根类逻辑
     */
    private void initSuperLogic() {

        //设置handler 监听
        setHandlerListener();
        //设置Home键时间监听
        registerHomeListener();
    }

    /**
     * 初始化根布局
     */
    private void initRootLayout() {

        int rootLayoutResId = getLayoutResId();
        if (0 != rootLayoutResId && -1 != rootLayoutResId) {
            setContentView(rootLayoutResId);
        }
    }

    /**
     * 注册广播监听
     */
    private void registerBroadCastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SuperBroadcastAction.NETWORK_CHANGE_ACTION);
        //注册子类广播
        Set<String> actionSet = getBroadCastAction();
        if (null != actionSet && actionSet.size() > 0) {
            for (String action : actionSet) {
                intentFilter.addAction(action);
            }
        }

        registerReceiver(broadcastReceiver, intentFilter);

    }

    protected Set<String> getBroadCastAction() {
        return null;
    }

    /**
     * 注销广播监听
     */
    private void unRegisterBroadCastReceiver() {
        if (null != broadcastReceiver) {
            unregisterReceiver(broadcastReceiver);
        }

    }

    /**
     * 设置handler 监听
     */
    private void setHandlerListener() {
        handler.setListener(new UIHandlerListener()

        {
            public void handleMessage(Message msg) {
                handleMsg(msg);// 有消息就提交给子类实现的方法
            }
        });
    }

    /**
     * 注册Home键的监听
     */
    private void registerHomeListener() {
        homeEventListener = new HomeEventListener(SuperBaseActivity.this);
        homeEventListener.setOnHomePressedListener(new HomeEventListener.OnHomePressedListener() {

            @Override
            public void onHomePressed() {
                LogUtils.e("onHomePressed:::SuperBaseActivity");
                SuperBaseActivity.this.onHomePressed();
            }

            @Override
            public void onHomeLongPressed() {
                LogUtils.e("onHomeLongPressed:::SuperBaseActivity");
                SuperBaseActivity.this.onHomeLongPressed();
            }
        });
        homeEventListener.startWatch();
    }

    /**
     * 处理广播事件
     *
     * @param intent
     */
    private void onSuperBroadcast(Intent intent) {
        // 处理各种情况
        String action = intent.getAction();
        if (SuperBroadcastAction.NETWORK_CHANGE_ACTION.equals(action)) { // 网络发生变化
            LogUtils.d("网络状况变化");
            if (NetUtils.isConnect(getApplicationContext())) {
                onNetConnected();
            } else {
                onNetDisConnected();
            }
        }

        //调用子类广播回调
        onBroadcast(intent);

    }


    /**
     * 当前类实现供子类调用方法----------------------------------start----------------------------------
     */

    /**
     * shortToast toast by string
     *
     * @param string
     */
    protected void shortToast(String string) {
        ToastUtils.shortToast(string);
    }

    /**
     * shortToast toast by res id
     *
     * @param resId
     */
    protected void shortToast(int resId) {
        ToastUtils.shortToast(resId);
    }

    /**
     * long toast
     *
     * @param string
     */
    protected void longToast(String string) {
        ToastUtils.longToast(string);
    }

    /**
     * long toast
     *
     * @param resId
     */
    protected void longToast(int resId) {
        ToastUtils.longToast(resId);
    }


    /**
     * 子类可override的回调方法---------------------------------start----------------------------------
     */


    /**
     * 广播回调事件
     *
     * @param intent
     */
    protected void onBroadcast(Intent intent) {
    }

    /**
     * 回调方法 Home键点击事件 回调方法
     */
    protected void onHomePressed() {

    }

    /**
     * 回调方法 Home键点击事件 回调方法
     */
    protected void onHomeLongPressed() {

    }

    /**
     * 网络连接上 回调方法
     */
    protected void onNetConnected() {
//        String connectType;
//        if (NetUtils.isWifiConnect(getApplicationContext())) {
//            connectType = "WiFi";
//
//        } else {
//            connectType = "手机网络";
//        }
//        shortToast("网络已经连接 连接类型：" + connectType);
    }

    /**
     * 网络断开 回调方法
     */
    protected void onNetDisConnected() {
        shortToast("网络已经断开");
    }


    /**
     * 子类必须实现的抽象方法----------------------------------start----------------------------------
     */

    /**
     * 获取页面Layout ResID
     *
     * @return
     */
    protected abstract int getLayoutResId();


    /**
     * 初始化 子类(BaseActivity) UI
     */
    protected abstract void initBaseUI();

    /**
     * 初始化子类(具体Activity)UI
     *
     * @return
     */
    protected abstract void initView();

    /**
     * 初始化子类逻辑
     */
    protected abstract void initLogic();

    /**
     * 执行子类逻辑 耗时等不建议放到 onCreate的操作在此执行
     */
    protected abstract void startLogic();


    /**
     * 全局点击事件 回调方法
     *
     * @param v
     */
    protected abstract void onViewClick(View v);

    /**
     * Handler 消息处理方法 回调方法
     *
     * @param msg
     */
    protected abstract void handleMsg(Message msg);

}




