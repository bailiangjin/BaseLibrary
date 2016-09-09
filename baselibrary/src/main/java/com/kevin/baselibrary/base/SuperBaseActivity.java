package com.kevin.baselibrary.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.base.tools.BaseActivityInterface;
import com.kevin.baselibrary.base.tools.TitleBarBuilder;
import com.kevin.baselibrary.constant.SuperBroadcastAction;
import com.kevin.baselibrary.interfaze.listener.UIHandlerListener;
import com.kevin.baselibrary.model.art.HomeEventListener;
import com.kevin.baselibrary.model.art.UIHandler;
import com.kevin.baselibrary.net.NetUtils;
import com.kevin.baselibrary.utils.KeyBoardUtils;
import com.kevin.baselibrary.utils.LogUtils;

import java.util.Set;

/**
 * Created by bailiangjin on 16/9/7.
 */
public abstract class SuperBaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements BaseActivityInterface {

    private Toolbar toolbar;

    protected TitleBarBuilder titleBarBuilder;

    public T binding;

    private FrameLayout baseContainer;


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

    /**
     * Handler 消息处理
     */
    protected UIHandler uiHandler = new UIHandler(Looper.getMainLooper());



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initIntentData();
        initSuperUI();
        initSuperLogic();
        if(getLayoutResId()>0){
            binding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutResId(), baseContainer, true);
        }
        initBaseView();
        initView();
        initData();
    }

    protected abstract void initBaseView();


    protected abstract int getLayoutResId();

    protected abstract void initIntentData();

    protected abstract void initView();

    protected abstract void initData();

    /**
     * 初始化父类UI
     */
    private void initSuperUI() {
        super.setContentView(R.layout.activity_binding_base_xml);
        baseContainer = (FrameLayout) findViewById(R.id.baseContainer);
        toolbar = (Toolbar) findViewById(com.kevin.baselibrary.R.id.toolbar);
        titleBarBuilder = new TitleBarBuilder(this, toolbar);
    }


    /**
     * 初始化根类逻辑
     */
    private void initSuperLogic() {

        //设置handler 监听
        setHandlerListener();
    }




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
        homeEventListener = new HomeEventListener(this);
        homeEventListener.setOnHomePressedListener(new HomeEventListener.OnHomePressedListener() {

            @Override
            public void onHomePressed() {
                LogUtils.e("onHomePressed:::SuperBaseActivity");
                this.onHomePressed();
            }

            @Override
            public void onHomeLongPressed() {
                LogUtils.e("onHomeLongPressed:::SuperBaseActivity");
                this.onHomeLongPressed();
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
     * 全局事件分发 实现 触摸非输入框控件 隐藏键盘
     *
     * @param motionEvent
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            KeyBoardUtils.closeKeyboardWhenCurFocusIsNotEt(SuperBaseActivity.this, motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /**
     * 隐藏公共title
     */
    public void hideCommonBaseTitle() {
        if (toolbar != null) {
            toolbar.setVisibility(View.GONE);
        }
    }

    /**
     * 显示公共的title
     */
    public void showCommonBaseTitle() {

        if (toolbar != null) {
            toolbar.setVisibility(View.VISIBLE);
        }
    }


    /**
     * 发送handle msg 可在handleMsg 处理
     *
     * @param msg
     */
    protected void sendHandlerMsg(Message msg) {
        uiHandler.sendMessage(msg);
    }



    /**
     * Handler 消息处理方法 回调方法
     *
     * @param msg
     */
    protected abstract void handleMsg(Message msg);

    public T getBinding() {
        return binding;
    }
}