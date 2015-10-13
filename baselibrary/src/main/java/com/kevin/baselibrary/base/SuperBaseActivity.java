package com.kevin.baselibrary.base;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.kevin.baselibrary.interfaze.listener.UIHandlerListener;
import com.kevin.baselibrary.model.art.HomeEventListener;
import com.kevin.baselibrary.model.art.UIHandler;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/9/28 23:10
 */
public abstract class SuperBaseActivity extends FragmentActivity implements View.OnClickListener {

    protected HomeEventListener homeListener;

    /**
     * Handler 消息处理
     */
    protected static UIHandler handler = new UIHandler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 初始化baseview
         */
        initSuperUI();
        initBaseView();

        //初始化子类布局
        initView();
        //初始化父类逻辑
        initSuperLogic();

        initLogic();
    }


    /**
     * 初始化父类UI
     */
    private void initSuperUI() {
        //初始化根布局
        initRootLayout();
    }

    private void initSuperLogic() {

        //设置handler 监听
        setHandlerListener();
        //设置Home键时间监听
        registerHomeListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        homeListener.startWatch();
    }


    @Override
    protected void onPause() {
        super.onPause();
        homeListener.stopWatch();
    }

    @Override
    public void onClick(View v) {
        onViewClick(v);

    }

    //当前类实现 方法

    /**
     * 初始化根布局
     */
    private void initRootLayout() {

        int rootLayoutResId = getLayoutResID();
        if (0 != rootLayoutResId && 1 != rootLayoutResId) {
            setContentView(rootLayoutResId);
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
     * show toast by string
     *
     * @param string
     */
    protected void show(String string) {
        ToastUtils.shortShow(SuperBaseActivity.this, string);
    }

    /**
     * show toast by res id
     *
     * @param resId
     */
    protected void show(int resId) {
        ToastUtils.shortShow(SuperBaseActivity.this, resId);
    }

    /**
     * long toast
     *
     * @param string
     */
    protected void longShow(String string) {
        ToastUtils.longShow(SuperBaseActivity.this, string);
    }

    /**
     * long toast
     *
     * @param resId
     */
    protected void longShow(int resId) {
        ToastUtils.longShow(SuperBaseActivity.this, resId);
    }


    /**
     * 注册Home键的监听
     */
    protected void registerHomeListener() {
        homeListener = new HomeEventListener(SuperBaseActivity.this);
        homeListener.setOnHomePressedListener(new HomeEventListener.OnHomePressedListener() {

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
        homeListener.startWatch();
    }

    protected void onHomePressed() {

    }

    protected void onHomeLongPressed() {

    }

    //子类必须实现的抽象方法

    /**
     * 初始化子类UI
     *
     * @return
     */
    protected abstract void initView();

    protected abstract void initBaseView();


    /**
     * 初始化子类逻辑
     */
    protected abstract void initLogic();

    /**
     * 获取页面Layout ID
     *
     * @return
     */
    protected abstract int getLayoutResID();

    /**
     * 全局点击事件
     *
     * @param v
     */
    protected abstract void onViewClick(View v);

    /**
     * Handler 消息处理方法
     *
     * @param msg
     */
    protected abstract void handleMsg(Message msg);

}




