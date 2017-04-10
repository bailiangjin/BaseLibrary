package com.bailiangjin.uilibrary.activity;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.bailiangjin.uilibrary.R;
import com.bailiangjin.uilibrary.titlebar.TitleBarBuilder;
import com.bailiangjin.uilibrary.utils.KeyBoardUtils;


/**
 * Created by bailiangjin on 16/9/7.
 */
public abstract class SuperBaseActivity extends AppCompatActivity implements BaseActivityInterface {

    private Toolbar toolbar;
    private LinearLayout ll_root;
    protected TitleBarBuilder titleBarBuilder;

    protected FrameLayout baseContainer;

    protected LayoutInflater layoutInflater;


    /**
     * Handler 消息处理
     */
    protected UIHandler uiHandler = new UIHandler(Looper.getMainLooper());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isHideBar()) {
            //初始化统一bar
           // CommonUtils.initSystemBar(this);
        }
        beforeViewBind(savedInstanceState);
        initSuperUI();
        initSuperLogic();
        //设置view 绑定
        bindView();
        initView(savedInstanceState);
        setStatusBar();
        initData(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        //放置handler 内存泄漏
        uiHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    /**
     * 初始化父类UI
     */
    private void initSuperUI() {
        super.setContentView(R.layout.activity_binding_base_xml);
        baseContainer = (FrameLayout) this.findViewById(R.id.baseContainer);
        toolbar = (Toolbar) this.findViewById(R.id.common_toolbar);
        titleBarBuilder = new TitleBarBuilder(SuperBaseActivity.this, toolbar);
        ll_root= (LinearLayout) this.findViewById(R.id.ll_root);
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(SuperBaseActivity.this);

        }
        if(0!=getLayoutResId()&&-1!=getLayoutResId()){
            View ChildView = layoutInflater.inflate(getLayoutResId(), null);
            baseContainer.removeAllViews();
            baseContainer.addView(ChildView);
        }
    }

    protected void displayFragment(Fragment fragment,boolean isAddToBackStack){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(R.id.baseContainer, fragment);    //通过事务去管理Fragment
        if (isAddToBackStack){
            beginTransaction.addToBackStack(null);    //处理返回键
        }

        beginTransaction.commit();  //提交
    }


    /**
     * 隐藏公共title
     */
    public void hideCommonBaseTitle() {
        if (toolbar != null) {
            toolbar.setVisibility(View.GONE);
        }
    }
//    /**
//     * 设置隐藏状态栏高度
//     */
//    public void hideStatusBarHeight(){
//        ll_root.setFitsSystemWindows(false);
//    }

    /**
     * 显示公共的title
     */
    public void showCommonBaseTitle() {

        if (toolbar != null) {
            toolbar.setVisibility(View.VISIBLE);
        }
    }


    /**
     * 初始化根类逻辑
     */
    private void initSuperLogic() {

        //设置handler 监听
        setHandlerListener();
    }


    /**
     * 设置handler 监听
     */
    private void setHandlerListener() {
        uiHandler.setListener(new UIHandlerListener()

        {
            public void handleMessage(Message msg) {
                handleMsg(msg);// 有消息就提交给子类实现的方法
            }
        });
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
     * 发送Empty  handle msg 可在handleMsg 处理
     *
     * @param what
     */
    protected void sendEmptyHandlerMsg(int what) {
        uiHandler.sendEmptyMessage(what);
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

    protected abstract int getLayoutResId();

    protected abstract void beforeViewBind(Bundle savedInstanceState);

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData(Bundle savedInstanceState);


    /**
     * Handler 消息处理方法 回调方法
     *
     * @param msg
     */
    protected abstract void handleMsg(Message msg);

    protected abstract boolean isHideBar();

}